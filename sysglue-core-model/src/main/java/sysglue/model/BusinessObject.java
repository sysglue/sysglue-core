package sysglue.model;

import java.io.Serializable;
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
	private Set<BusinessObjectVersion> businessObjectVersions;
	
	
	public Set<BusinessObjectVersion> getBusinessObjectVersions() {
		return businessObjectVersions;
	}

	public void setBusinessObjectVersions(Set<BusinessObjectVersion> businessObjectVersions) {
		this.businessObjectVersions = businessObjectVersions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	
}
