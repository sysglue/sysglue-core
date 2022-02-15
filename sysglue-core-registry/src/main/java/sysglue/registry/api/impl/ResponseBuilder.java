package sysglue.registry.api.impl;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sysglue.api.model.ApiError;

@ApplicationScoped
public class ResponseBuilder {
    
    public Response internalError(Exception e){

        return  Response.serverError().entity(new ApiError(Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
        Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage())).build();

    }

    public Response notModified(){
        
        return Response.status(Status.NOT_MODIFIED).entity(new ApiError(Status.NOT_MODIFIED.getReasonPhrase(),
                        Status.NOT_MODIFIED.getStatusCode(), "Not found no records deleted")).build();

    }

    public Response persistenceException(PersistenceException e){
        return Response.status(Status.CONFLICT).entity(new ApiError(Status.CONFLICT.getReasonPhrase(),
        Status.CONFLICT.getStatusCode(), e.getMessage())).build();
    }

    public Response notFound(Serializable id){
        return Response.status(Status.NOT_FOUND).entity(new ApiError(Status.NOT_FOUND.getReasonPhrase(),
        Status.NOT_FOUND.getStatusCode(),id + " Not found")).build();
    }
}
