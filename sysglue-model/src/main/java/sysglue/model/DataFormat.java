package sysglue.model;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DataFormat extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	public BusinessObjectVersion businessObjectVersion;
	
	//xsd, jsonschema or csv ...	
	public String schema;
	
	public String sample;
}
