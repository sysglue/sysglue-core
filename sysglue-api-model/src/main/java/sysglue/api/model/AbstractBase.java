package sysglue.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractBase{

    @JsonProperty(required=true)
    @JsonPropertyDescription("Unique name of the object")
    public String name;

    public String description; 

    @JsonPropertyDescription("Whether the object is activated when routing flows")
    public Boolean activated;

    public AbstractBase(String name, String description, Boolean activated) {
        this.name = name;
        this.description = description;
        this.activated = activated;
    }

    public AbstractBase() {
    }


    @Override
    public String toString() {
        return "AbstractBase [activated=" + activated + ", description=" + description + ", name=" + name + "]";
    }

    
}