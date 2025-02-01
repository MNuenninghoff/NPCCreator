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

/**
 * DAO to access the IronArachne name generator (muna.ironarachne.com)
 */
public class IronArachneDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties;

    /**
     * No Argument constructor. Loads properties file with uri
     */
    public IronArachneDao() {
        this.properties = loadProperties("/npcCreator.properties", logger);
    }

    /**
     * Returns a random name of a specified race and type (male/female/family)
     * @param race      race (will default to human if a non-supported race is supplied)
     * @param nameType  type of name (male/female/family)
     * @return          name of specified race and type
     */
    public Name getName(String race, String nameType) {
        String apiTargetString = properties.getProperty("IronArachneURI") + race + "/?count=1?nameType=" + nameType;
        logger.debug("getName API request URI: " + apiTargetString);
        Name name = queryAPI(apiTargetString, nameType);
        return name;
    }
    /**
     * Queries the IronArachne api using the passed targetString and returns the json object mapped
     * as a name
     * @param apiTargetString   api target string (e.g. https://muna.ironarachne.com/human/?count=1?nameType=family"
     *                          looks like string has changed to https://names.ironarachne.com/race/raceHere/type/counthere
     * @param nameType  Type of name to request (male/female/family). Needed in case original api query fails due to
     *                  unsupported race.
     * @return          Randomly generated name returned from ironarachne
     */
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
                    name = getName("human", "male");
                    return name;
                case "female":
                    name = getName("human", "female");
                    return name;
                case "family":
                    name = getName("human", "family");
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
