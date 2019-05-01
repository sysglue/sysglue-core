package sysglue.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	public BusinessObject getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(BusinessObject businessObject) {
		this.businessObject = businessObject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<DataFormat> getDataFormats() {
		return dataFormats;
	}

	public void setDataFormats(Set<DataFormat> dataFormats) {
		this.dataFormats = dataFormats;
	}
	
	
	
}
