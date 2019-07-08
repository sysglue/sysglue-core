package sysglue.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@MappedSuperclass
public abstract class AbstractBaseEntity extends PanacheEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique=true)
	public String name;
	
	public String description;
	
	public Boolean activated;
	
}
