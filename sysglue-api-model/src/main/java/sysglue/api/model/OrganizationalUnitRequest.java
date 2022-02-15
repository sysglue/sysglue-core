package sysglue.api.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationalUnitRequest extends AbstractBase {

    public OrganizationalUnitRequest(String name, String description, Boolean activated) {
        super(name, description, activated);
    }
    
    public OrganizationalUnitRequest(){
    }
}
