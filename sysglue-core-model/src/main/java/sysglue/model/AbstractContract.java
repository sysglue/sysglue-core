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
	protected OrganisationalUnit organisationalUnit;

	public OrganisationalUnit getOrganisationalUnit() {
		return organisationalUnit;
	}

	public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnit = organisationalUnit;
	}
	
	
}
