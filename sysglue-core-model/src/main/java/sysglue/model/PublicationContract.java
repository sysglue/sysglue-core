package sysglue.model;

import javax.persistence.Entity;

@Entity
public class PublicationContract extends AbstractContract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean validationEnabled;

	public void setValidationEnabled(Boolean validationEnabled) {
		this.validationEnabled = validationEnabled;
	}
	
	
}
