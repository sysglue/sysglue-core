package sysglue.api.model;


import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationalUnitResponse extends OrganizationalUnitRequest{

    @JsonProperty(required=true)
    @JsonUnwrapped
    public BaseId baseId;

    @JsonPropertyDescription("Set of pub contracts")
    public Set<String> publicationContractNames;

    @JsonPropertyDescription("Set of sub contracts")
    public Set<String> subscriptionContractNames;

    public OrganizationalUnitResponse(String name, String description, Boolean activated, UUID id,
            Set<String> publicationContractNames, Set<String> subscriptionContractNames) {
        super(name, description, activated);
        this.baseId = new BaseId(id);
        this.publicationContractNames = publicationContractNames;
        this.subscriptionContractNames = subscriptionContractNames;
    }

    public OrganizationalUnitResponse(String name, String description, Boolean activated, UUID id) {
        super(name, description, activated);
        this.baseId = new BaseId(id);
        this.publicationContractNames = new LinkedHashSet<String>();
        this.subscriptionContractNames = new LinkedHashSet<String>();
    }

    public OrganizationalUnitResponse(){
        this.baseId = new BaseId();
        this.publicationContractNames = new LinkedHashSet<String>();
        this.subscriptionContractNames = new LinkedHashSet<String>();
    }
}
