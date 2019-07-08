package sysglue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sysglue.model.BusinessObject;

@Path("/ping")
public class Ping {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BusinessObject hello() {
        BusinessObject b = BusinessObject.findAll().firstResult();
        return b;
    }
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String methodname() {
        return "hello";
    }
}