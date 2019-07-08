package sysglue.model;

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
	public BusinessObject businessObject;
	
	@OneToMany(mappedBy = "businessObjectVersion")
	public Set<DataFormat> dataFormats;
	
}
