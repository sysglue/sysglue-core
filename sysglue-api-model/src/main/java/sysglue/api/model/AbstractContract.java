package sysglue.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractContract extends AbstractBase{
    
    @JsonProperty(required=true)
    @JsonPropertyDescription("Reference to unique name of org unit")
    public String organizationalUnitName;

    @JsonProperty(required=true)
    @JsonPropertyDescription("Reference artifact id of a schema form Apicurio Service Registry")
    public String schemaArtifactId;

    @JsonProperty(required=true)
    @JsonPropertyDescription("Reference artifact version of a schema form Apicurio Service Registry")
    public Integer schemaVersion;

    public AbstractContract(String name, String description, Boolean activated, String organizationalUnitName,
            String schemaArtifactId, Integer schemaVersion) {
        super(name, description, activated);
        this.organizationalUnitName = organizationalUnitName;
        this.schemaArtifactId = schemaArtifactId;
        this.schemaVersion = schemaVersion;
    }

    public AbstractContract(){}

    @Override
    public String toString() {
        return "AbstractContract [organizationalUnitName=" + organizationalUnitName + ", schemaArtifactId="
                + schemaArtifactId + ", schemaVersion=" + schemaVersion + "]";
    }

    
}
