package sysglue.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractContract extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	public OrganizationalUnit organizationalUnit;

	@ManyToOne
	public DataFormat dataFormat;

}
