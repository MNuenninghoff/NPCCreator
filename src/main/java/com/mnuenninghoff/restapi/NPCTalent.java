package com.mnuenninghoff.restapi;

import com.mnuenninghoff.entity.Talent;
import com.mnuenninghoff.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/talents")
public class NPCTalent {

    private final Logger logger = LogManager.getLogger(this.getClass());

    //Method to process HTTP GET requests
    @GET
    @Produces("text/json")
    public Response getTalents() {
        //Return all talents as a json object
        GenericDao<Talent> talentDao = new GenericDao<Talent>(Talent.class);
        List<Talent> talents = talentDao.getAll();

        //Start JSON response
        String output = "{";
        int counter = 0;
        for (Talent talent : talents) {
            // add the talent to the JSON string
            output += "{\"id\":\"" + talent.getId() + "\",\"talent\":\"" + talent.getTalent() + "\"}";
            if (++counter != talents.size()) {
                // not the last loop, append a comma
                output += ",";
            }
        }

        // End JSON Response
        output += "}";

        return Response.status(200).entity(output).build();
    }

    /**
     * returns a talent based on the passed id
     */
    @GET
    @Path("/{id}")
    @Produces("text/JSON")
    public Response getMessage(@PathParam("id") int id) {

        String output = "{";
        GenericDao<Talent> talentDao = new GenericDao<Talent>(Talent.class);
        try {
            Talent talent = talentDao.getById(id);
            output += "{\"id\":\"" + talent.getId() + ",\"" + talent.getTalent() + "\"}";
        } catch (NullPointerException nullPointer) {
            logger.error("Error requesting Talent: " + id, nullPointer);
            return Response.status(404).build();
        } catch (Exception exception) {
            logger.error("There was an error", exception);
            return Response.status(404).build();
        }
        output += "}";

        return Response.status(200).entity(output).build();
    }
}
