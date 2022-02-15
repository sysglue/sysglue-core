package sysglue.api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicationContractResponse extends PublicationContractRequest {
 
    @JsonProperty(required=true)
    @JsonUnwrapped
    public BaseId baseId;

    public PublicationContractResponse(String name, String description, Boolean activated,
            String organizationalUnitName, String schemaArtifactId, Integer schemaVersion, Boolean validationEnabled,UUID id) {
        super(name, description, activated, organizationalUnitName, schemaArtifactId, schemaVersion, validationEnabled);
        this.baseId = new BaseId(id);

    }

    public PublicationContractResponse() {
        this.baseId = new BaseId();
    }

    
}
