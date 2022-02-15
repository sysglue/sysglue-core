package sysglue.api.interfaces;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import sysglue.api.model.ApiError;
import sysglue.api.model.BaseId;
import sysglue.api.model.SubscriptionContractRequest;
import sysglue.api.model.SubscriptionContractResponse;

@Path("/subscription-contract")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SubscriptionContractInterface {
  
  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "200",
            description = "Result found",
            content = @Content(
                schema = @Schema(
                    implementation = SubscriptionContractResponse.class
                )
            )
        ),
        @APIResponse(
          responseCode = "404",
          description = "No result found",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @GET
  @Path("/{id}")
  Response get(@PathParam("id") UUID id);


  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "201",
            description = "Record created",
            content = @Content(
                schema = @Schema(
                    implementation = BaseId.class
                )
            )
        ),
        @APIResponse(
          responseCode = "409",
          description = "Contraint violation",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @POST
  Response create(SubscriptionContractRequest input);


  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "200",
            description = "Record updated",
            content = @Content(
                schema = @Schema(
                    implementation = BaseId.class
                )
            )
        ),
        @APIResponse(
          responseCode = "201",
          description = "Record created",
          content = @Content(
              schema = @Schema(
                  implementation = BaseId.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @Path("/{id}")
  @PUT
  Response updateOrCreate(@PathParam("id") UUID id, SubscriptionContractRequest input);



  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "200",
            description = "Deleted successfully",
            content = @Content(
                schema = @Schema(
                    implementation =  BaseId.class
                )
            )
        ),
        @APIResponse(
          responseCode = "304",
          description = "Record does not exist, nothing to delete",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @Path("/{id}")
  @DELETE
  Response delete(@PathParam("id") UUID id);


  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "200",
            description = "Results found",
            content = @Content(
                schema = @Schema(
                    type = SchemaType.ARRAY,
                    implementation = SubscriptionContractResponse.class
                )
            )
        ),
        @APIResponse(
          responseCode = "404",
          description = "No results found",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @GET
  @Produces("application/json")
  Response search(@QueryParam("page") Long page,
      @QueryParam("size") Long size, @QueryParam("sort") String sort);

      
  @APIResponses(
    value = {
        @APIResponse(
            responseCode = "200",
            description = "Result found",
            content = @Content(
                schema = @Schema(
                    implementation = SubscriptionContractResponse.class
                )
            )
        ),
        @APIResponse(
          responseCode = "404",
          description = "No result found",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      ),
      @APIResponse(
          responseCode = "500",
          description = "Internal Error",
          content = @Content(
              schema = @Schema(
                  implementation = ApiError.class
              )
          )
      )
    })
  @GET
  @Path("/named/{name}")
  Response getByName(@PathParam("name") String name);
}