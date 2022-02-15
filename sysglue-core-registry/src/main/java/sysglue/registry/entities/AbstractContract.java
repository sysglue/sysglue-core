package sysglue.registry.entities;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
public abstract class AbstractContract extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JsonIgnoreProperties({"publicationContracts", "subscriptionContracts"})
	public OrganizationalUnit organizationalUnit;

	// global artifact id from apicurio schema registry
	public String schemaId;

}
