package sysglue.api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseId {
    
    @JsonProperty(required=true)
    public UUID id;

    public BaseId(UUID id) {
        this.id = id;
    }

    public BaseId() {
    }
    
    @Override
    public String toString() {
        return "BaseId [id=" + id + "]";
    }

    
}
