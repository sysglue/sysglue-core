package sysglue.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class OrganisationalUnit extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="organisationalUnit")
	private Set<PublicationContract> publicationContracts;
}
