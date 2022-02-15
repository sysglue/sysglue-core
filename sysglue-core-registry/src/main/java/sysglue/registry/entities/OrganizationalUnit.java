package sysglue.registry.entities;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


 
@Entity
public class OrganizationalUnit extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="organizationalUnit")
	public Set<PublicationContract> publicationContracts;

	@OneToMany(mappedBy="organizationalUnit")
	public Set<SubscriptionContract> subscriptionContracts;

	public OrganizationalUnit(UUID id, String name, String description, Boolean activated) {
		super(id, name, description, activated);
	}
	public OrganizationalUnit(String name, String description, Boolean activated) {
		super(name, description, activated);
	}
	public OrganizationalUnit() {
	}

	
}
