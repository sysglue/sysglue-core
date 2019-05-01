package sysglue.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DataFormat extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private BusinessObjectVersion businessObjectVersion;
	
	//xsd, jsonschema or csv ...	
	private String schema;
	
	private String sample;


	public BusinessObjectVersion getBusinessObjectVersion() {
		return businessObjectVersion;
	}

	public void setBusinessObjectVersion(BusinessObjectVersion businessObjectVersion) {
		this.businessObjectVersion = businessObjectVersion;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}
	
	
	
}
