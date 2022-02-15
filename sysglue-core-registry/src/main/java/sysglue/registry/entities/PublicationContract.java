package sysglue.registry.entities;


import javax.persistence.Entity;


@Entity
public class PublicationContract extends AbstractContract {

	private static final long serialVersionUID = 1L;
	
	public Boolean validationEnabled;

}
