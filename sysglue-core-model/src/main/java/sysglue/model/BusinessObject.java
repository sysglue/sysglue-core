package sysglue.model;

import java.util.Objects;
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
	


	public BusinessObject() {
	}

	public BusinessObject(Set<BusinessObjectVersion> businessObjectVersions) {
		this.businessObjectVersions = businessObjectVersions;
	}

	public Set<BusinessObjectVersion> getBusinessObjectVersions() {
		return this.businessObjectVersions;
	}

	public void setBusinessObjectVersions(Set<BusinessObjectVersion> businessObjectVersions) {
		this.businessObjectVersions = businessObjectVersions;
	}

	public BusinessObject businessObjectVersions(Set<BusinessObjectVersion> businessObjectVersions) {
		this.businessObjectVersions = businessObjectVersions;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof BusinessObject)) {
			return false;
		}
		BusinessObject businessObject = (BusinessObject) o;
		return Objects.equals(businessObjectVersions, businessObject.businessObjectVersions);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(businessObjectVersions);
	}

	@Override
	public String toString() {
		return "{" +
			" businessObjectVersions='" + getBusinessObjectVersions() + "'" +
			"}";
	}
	
}
