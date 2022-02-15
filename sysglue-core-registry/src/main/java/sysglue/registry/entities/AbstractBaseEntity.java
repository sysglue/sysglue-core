package sysglue.registry.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@MappedSuperclass
public abstract class AbstractBaseEntity extends PanacheEntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "UUID")
	public UUID id;

	@Column(unique=true)
	public String name;
	
	public String description;
	
	public Boolean activated;

	public AbstractBaseEntity(UUID id, String name, String description, Boolean activated) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.activated = activated;
	}

	public AbstractBaseEntity(String name, String description, Boolean activated) {
		this.name = name;
		this.description = description;
		this.activated = activated;
	}

	public AbstractBaseEntity() {
	}
	
	
}
