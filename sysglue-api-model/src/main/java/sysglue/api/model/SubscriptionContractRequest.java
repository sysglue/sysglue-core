package sysglue.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionContractRequest extends AbstractContract {

    @JsonProperty(required=true)
    @JsonPropertyDescription("Output endpoint to route to")
    public String outputEndpoint;

    public SubscriptionContractRequest(String name, String description, Boolean activated,
            String organizationalUnitName, String schemaArtifactId, Integer schemaVersion, String outputEndpoint) {
        super(name, description, activated, organizationalUnitName, schemaArtifactId, schemaVersion);
        this.outputEndpoint = outputEndpoint;
    }

    public SubscriptionContractRequest() {
    }
    
    
}
