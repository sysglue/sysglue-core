package sysglue.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicationContractRequest extends AbstractContract {
    
    @JsonProperty(required=true)
    @JsonPropertyDescription("If validation should be performed on payload before routing")
    public Boolean validationEnabled;

    public PublicationContractRequest(String name, String description, Boolean activated, String organizationalUnitName,
            String schemaArtifactId, Integer schemaVersion, Boolean validationEnabled) {
        super(name, description, activated, organizationalUnitName, schemaArtifactId, schemaVersion);
        this.validationEnabled = validationEnabled;
    }

    public PublicationContractRequest() {
    }

    
}
