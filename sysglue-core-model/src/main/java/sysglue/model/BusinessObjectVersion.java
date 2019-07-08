package sysglue.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BusinessObjectVersion extends AbstractBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private BusinessObject businessObject;
	
	@OneToMany(mappedBy = "businessObjectVersion")
	private Set<DataFormat> dataFormats;
	

	public BusinessObjectVersion() {
	}

	public BusinessObjectVersion(BusinessObject businessObject, Set<DataFormat> dataFormats) {
		this.businessObject = businessObject;
		this.dataFormats = dataFormats;
	}

	public BusinessObject getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(BusinessObject businessObject) {
		this.businessObject = businessObject;
	}

	public Set<DataFormat> getDataFormats() {
		return this.dataFormats;
	}

	public void setDataFormats(Set<DataFormat> dataFormats) {
		this.dataFormats = dataFormats;
	}

	public BusinessObjectVersion businessObject(BusinessObject businessObject) {
		this.businessObject = businessObject;
		return this;
	}

	public BusinessObjectVersion dataFormats(Set<DataFormat> dataFormats) {
		this.dataFormats = dataFormats;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof BusinessObjectVersion)) {
			return false;
		}
		BusinessObjectVersion businessObjectVersion = (BusinessObjectVersion) o;
		return Objects.equals(businessObject, businessObjectVersion.businessObject) && Objects.equals(dataFormats, businessObjectVersion.dataFormats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessObject, dataFormats);
	}

	@Override
	public String toString() {
		return "{" +
			" businessObject='" + getBusinessObject() + "'" +
			", dataFormats='" + getDataFormats() + "'" +
			"}";
	}
	
	
}
