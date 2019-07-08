package sysglue.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class BusinessObject extends AbstractBaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "businessObject")
	public Set<BusinessObjectVersion> businessObjectVersions;
	
}
