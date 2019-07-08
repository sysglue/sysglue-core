package sysglue.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class OrganizationalUnit extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="organizationalUnit")
	private Set<PublicationContract> publicationContracts;


	public OrganizationalUnit() {
	}

	public OrganizationalUnit(Set<PublicationContract> publicationContracts) {
		this.publicationContracts = publicationContracts;
	}

	public Set<PublicationContract> getPublicationContracts() {
		return this.publicationContracts;
	}

	public void setPublicationContracts(Set<PublicationContract> publicationContracts) {
		this.publicationContracts = publicationContracts;
	}

	public OrganizationalUnit publicationContracts(Set<PublicationContract> publicationContracts) {
		this.publicationContracts = publicationContracts;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof OrganizationalUnit)) {
			return false;
		}
		OrganizationalUnit organizationalUnit = (OrganizationalUnit) o;
		return Objects.equals(publicationContracts, organizationalUnit.publicationContracts);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(publicationContracts);
	}

	@Override
	public String toString() {
		return "{" +
			" publicationContracts='" + getPublicationContracts() + "'" +
			"}";
	}


}
