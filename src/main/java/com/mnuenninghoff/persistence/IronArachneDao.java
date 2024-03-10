package com.mnuenninghoff.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnuenninghoff.entity.Name;
import com.mnuenninghoff.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

public class IronArachneDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties;

    /**
     * No Argument constructor. Loads properties file with uri
     */
    public IronArachneDao() {
        this.properties = loadProperties("/npcCreator.properties");
    }

    public Name getMaleFirstName(String race) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=male";
        logger.debug("API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString, "male");
        return name;
    }
    public Name getFemaleFirstName(String race) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=female";
        logger.debug("API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString,"female");
        return name;
    }
    public Name getFamilyName(String race) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=family";
        logger.debug("API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString, "family");
        return name;
    }
    private Name queryAPI(String apiTargetString, String nameType) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(apiTargetString);
        String response = null;
        Name name = null;
        try {
            response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            logger.debug(response);
        } catch (NotFoundException notFound) {
            logger.error("Web Resource Not Found");
            // If the name generator api returns a 404 not found error, retry with a race that is known to work
            // (Human) and return a human name
            switch(nameType) {
                case "male":
                    name = getMaleFirstName("human");
                    return name;
                case "female":
                    name = getFemaleFirstName("human");
                    return name;
                case "family":
                    name = getFamilyName("human");
                    return name;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            name = mapper.readValue(response, Name.class);
        } catch (JsonProcessingException e) {
            logger.error("There was a problem mapping the object: ", e);
        }
        return name;
    }
}
