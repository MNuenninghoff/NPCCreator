package com.mnuenninghoff.restapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// Defines the base URI for all resource URIs
@ApplicationPath("/services") // value added so that not all traffic is routed to this class
/**
 * Declares root resource and provider classes
 */
public class NPCApplication extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<Class<?>>();
        h.add(NPCTalent.class );
        return h;
    }

}
