package com.mnuenninghoff.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnuenninghoff.entity.Name;
import com.mnuenninghoff.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        Name name = queryAPI(apiTargetString);
        return name;
    }
    public Name getFemaleFirstName(String race) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=female";
        logger.debug("API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString);
        return name;
    }
    public Name getFamilyName(String race) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=family";
        logger.debug("API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString);
        return name;
    }
    private Name queryAPI(String apiTargetString) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(apiTargetString);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug(response);
        ObjectMapper mapper = new ObjectMapper();
        Name name = null;
        try {
            name = mapper.readValue(response, Name.class);
        } catch (JsonProcessingException e) {
            logger.error("There was a problem mapping the object: ", e);
        }
        return name;
    }
}
