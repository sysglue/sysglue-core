package sysglue.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	protected Long id;
	
	@Column(unique=true)
	protected String name;
	
	protected String description;
	
	protected Boolean activated;
	

	public AbstractBaseEntity() {
	}

	public AbstractBaseEntity(Long id, String name, String description, Boolean activated) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.activated = activated;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isActivated() {
		return this.activated;
	}

	public Boolean getActivated() {
		return this.activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public AbstractBaseEntity id(Long id) {
		this.id = id;
		return this;
	}

	public AbstractBaseEntity name(String name) {
		this.name = name;
		return this;
	}

	public AbstractBaseEntity description(String description) {
		this.description = description;
		return this;
	}

	public AbstractBaseEntity activated(Boolean activated) {
		this.activated = activated;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AbstractBaseEntity)) {
			return false;
		}
		AbstractBaseEntity abstractBaseEntity = (AbstractBaseEntity) o;
		return Objects.equals(id, abstractBaseEntity.id) && Objects.equals(name, abstractBaseEntity.name) && Objects.equals(description, abstractBaseEntity.description) && Objects.equals(activated, abstractBaseEntity.activated);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, activated);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", description='" + getDescription() + "'" +
			", activated='" + isActivated() + "'" +
			"}";
	}
	
}
