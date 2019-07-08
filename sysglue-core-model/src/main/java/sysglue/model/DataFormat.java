package sysglue.model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DataFormat extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private BusinessObjectVersion businessObjectVersion;
	
	//xsd, jsonschema or csv ...	
	private String schema;
	
	private String sample;

	
	public DataFormat() {
	}

	public DataFormat(BusinessObjectVersion businessObjectVersion, String schema, String sample) {
		this.businessObjectVersion = businessObjectVersion;
		this.schema = schema;
		this.sample = sample;
	}

	public BusinessObjectVersion getBusinessObjectVersion() {
		return this.businessObjectVersion;
	}

	public void setBusinessObjectVersion(BusinessObjectVersion businessObjectVersion) {
		this.businessObjectVersion = businessObjectVersion;
	}

	public String getSchema() {
		return this.schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getSample() {
		return this.sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public DataFormat businessObjectVersion(BusinessObjectVersion businessObjectVersion) {
		this.businessObjectVersion = businessObjectVersion;
		return this;
	}

	public DataFormat schema(String schema) {
		this.schema = schema;
		return this;
	}

	public DataFormat sample(String sample) {
		this.sample = sample;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof DataFormat)) {
			return false;
		}
		DataFormat dataFormat = (DataFormat) o;
		return Objects.equals(businessObjectVersion, dataFormat.businessObjectVersion) && Objects.equals(schema, dataFormat.schema) && Objects.equals(sample, dataFormat.sample);
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessObjectVersion, schema, sample);
	}

	@Override
	public String toString() {
		return "{" +
			" businessObjectVersion='" + getBusinessObjectVersion() + "'" +
			", schema='" + getSchema() + "'" +
			", sample='" + getSample() + "'" +
			"}";
	}
	
}
