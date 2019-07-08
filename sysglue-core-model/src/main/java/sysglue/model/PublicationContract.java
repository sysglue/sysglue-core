package sysglue.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class PublicationContract extends AbstractContract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean validationEnabled;

	public PublicationContract() {
	}

	public PublicationContract(Boolean validationEnabled) {
		this.validationEnabled = validationEnabled;
	}

	public Boolean isValidationEnabled() {
		return this.validationEnabled;
	}

	public Boolean getValidationEnabled() {
		return this.validationEnabled;
	}

	public void setValidationEnabled(Boolean validationEnabled) {
		this.validationEnabled = validationEnabled;
	}

	public PublicationContract validationEnabled(Boolean validationEnabled) {
		this.validationEnabled = validationEnabled;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PublicationContract)) {
			return false;
		}
		PublicationContract publicationContract = (PublicationContract) o;
		return Objects.equals(validationEnabled, publicationContract.validationEnabled);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(validationEnabled);
	}

	@Override
	public String toString() {
		return "{" +
			" validationEnabled='" + isValidationEnabled() + "'" +
			"}";
	}

}
