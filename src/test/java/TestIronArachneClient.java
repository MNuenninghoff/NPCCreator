import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnuenninghoff.entity.Name;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIronArachneClient {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Test
    public void testIronArachneJSON() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://muna.ironarachne.com/dwarf/?count=1?nameType=male");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug(response);
        ObjectMapper mapper = new ObjectMapper();
        Name name = null;
       try {
            name = mapper.readValue(response, Name.class);
       } catch (JsonProcessingException e) {
            logger.error("There was a problem mapping the object: ", e);
       }
       assertEquals(1, name.getNames().size());
       assertEquals(1, name.getCount());

       target = client.target("https://muna.ironarachne.com/dwarf/?count=5?nameType=male");
       response = target.request(MediaType.APPLICATION_JSON).get(String.class);
       logger.debug(response);
       Name name2 = null;
       try {
           name2 = mapper.readValue(response, Name.class);
       } catch(JsonProcessingException e) {
           logger.error("There was a problem mapping the object: ", e);
       }
       assertEquals(5, name2.getCount());
       assertEquals(5, name2.getNames().size());
    }
}
