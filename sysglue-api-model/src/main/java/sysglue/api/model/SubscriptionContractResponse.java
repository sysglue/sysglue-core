package sysglue.api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionContractResponse extends SubscriptionContractRequest {

    @JsonProperty(required=true)
    @JsonUnwrapped
    public BaseId baseId=new BaseId();

    public SubscriptionContractResponse(String name, String description, Boolean activated,
            String organizationalUnitName, String schemaArtifactId, Integer schemaVersion, String outputEndpoint, UUID id) {
        super(name, description, activated, organizationalUnitName, schemaArtifactId, schemaVersion, outputEndpoint);
        this.baseId= new BaseId(id);
    }

    public SubscriptionContractResponse() {
        this.baseId = new BaseId();
    }


    
}
