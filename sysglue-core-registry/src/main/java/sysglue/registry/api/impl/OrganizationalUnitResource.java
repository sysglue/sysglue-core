package sysglue.registry.api.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;

import io.quarkus.arc.ArcUndeclaredThrowableException;
import sysglue.api.interfaces.OrganizationalUnitInterface;
import sysglue.api.model.ApiError;
import sysglue.api.model.BaseId;
import sysglue.api.model.OrganizationalUnitRequest;
import sysglue.api.model.OrganizationalUnitResponse;
import sysglue.registry.entities.OrganizationalUnit;

public class OrganizationalUnitResource implements OrganizationalUnitInterface {

    @Inject
    private Logger logger;

    @Inject
    private ResponseBuilder responseBuilder;

    private OrganizationalUnitResponse mappingDbToApi(OrganizationalUnit organizationalUnit) {

        OrganizationalUnitResponse response = new OrganizationalUnitResponse(organizationalUnit.name,
                organizationalUnit.description, organizationalUnit.activated, organizationalUnit.id);

        organizationalUnit.publicationContracts.forEach(pubContract -> {
            response.publicationContractNames.add(pubContract.name);
        });

        organizationalUnit.subscriptionContracts.forEach(subContract -> {
            response.subscriptionContractNames.add(subContract.name);
        });

        return response;

    }

    private OrganizationalUnit mappingApiToDb(OrganizationalUnitRequest organizationalUnitRequest) {
        OrganizationalUnit organizationalUnit = new OrganizationalUnit(organizationalUnitRequest.name,
                organizationalUnitRequest.description, organizationalUnitRequest.activated);
        return organizationalUnit;

    }

    @Override
    public Response get(UUID id) {

        try {
            OrganizationalUnit queryResult = OrganizationalUnit.findById(id);
            if (queryResult!=null){
                return Response.ok(mappingDbToApi(queryResult)).build();
            }else{
                return responseBuilder.notFound(id);
            }
            
        } 
        catch (Exception e) {

            logger.error("get error", e);
            return responseBuilder.internalError(e);
        }

    }

    @Transactional
    @Override
    public Response updateOrCreate(UUID id, OrganizationalUnitRequest data) {
        OrganizationalUnit organizationalUnit = mappingApiToDb(data);
        try {
            OrganizationalUnit previous = OrganizationalUnit.findById(id);
            organizationalUnit = previous.getEntityManager().merge(organizationalUnit);
            organizationalUnit.persist();
            BaseId baseId = new BaseId(organizationalUnit.id);
            return Response.status(Status.CREATED).entity(baseId).build();
        } 
        catch (Exception e) {

            logger.error("create error", e);
            return responseBuilder.internalError(e);

        }
    }

    @Transactional
    @Override
    public Response create(OrganizationalUnitRequest data) {
        OrganizationalUnit organizationalUnit = mappingApiToDb(data);
        try {

            organizationalUnit.persistAndFlush();
            BaseId baseId = new BaseId(organizationalUnit.id);
            return Response.status(Status.CREATED).entity(baseId).build();
            
        } 
        catch (PersistenceException persistenceException){

            logger.error("create constraint error", persistenceException);
            
            return responseBuilder.persistenceException(persistenceException);
        }
        catch (Exception e) {

            logger.error("create error", e);

            return responseBuilder.internalError(e);

        }
    }

    @Transactional
    @Override
    public Response delete(UUID id) {

        try {
            if (OrganizationalUnit.deleteById(id)) {
        
                return Response.ok(new BaseId(id)).build();
        
            } else {
        
                return responseBuilder.notModified();
            }
        } catch (Exception e) {

            logger.error("delete error", e);
            return responseBuilder.internalError(e);

        }
    }

    @Override
    public Response search(Long page, Long size, String sort) {
        
        try {
            List<OrganizationalUnit> queryResults = OrganizationalUnit.listAll();
            return Response.ok(queryResults.stream().map(ou -> mappingDbToApi(ou)).collect(Collectors.toList())).build();

        } catch (Exception e) {

            logger.error("search error", e);
            return responseBuilder.internalError(e);
            
        }

    }

    @Override
    public Response getByName(String name) {
        try {
            OrganizationalUnit queryResult = OrganizationalUnit.find("name",name).firstResult();
            if (queryResult!=null){
                return Response.ok(mappingDbToApi(queryResult)).build();
            }else{
                return responseBuilder.notFound(name);
            }
            
        } 
        catch (Exception e) {

            logger.error("get error", e);
            return responseBuilder.internalError(e);
        }
    }

}
