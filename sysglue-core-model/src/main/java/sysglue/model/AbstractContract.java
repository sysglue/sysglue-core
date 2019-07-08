package sysglue.model;

import java.util.Objects;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractContract extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	protected OrganizationalUnit organizationalUnit;

	@ManyToOne
	protected DataFormat dataFormat;

	public AbstractContract() {
	}

	public AbstractContract(OrganizationalUnit organizationalUnit, DataFormat dataFormat) {
		this.organizationalUnit = organizationalUnit;
		this.dataFormat = dataFormat;
	}

	public OrganizationalUnit getOrganizationalUnit() {
		return this.organizationalUnit;
	}

	public void setOrganizationalUnit(OrganizationalUnit organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public DataFormat getDataFormat() {
		return this.dataFormat;
	}

	public void setDataFormat(DataFormat dataFormat) {
		this.dataFormat = dataFormat;
	}

	public AbstractContract organizationalUnit(OrganizationalUnit organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
		return this;
	}

	public AbstractContract dataFormat(DataFormat dataFormat) {
		this.dataFormat = dataFormat;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AbstractContract)) {
			return false;
		}
		AbstractContract abstractContract = (AbstractContract) o;
		return Objects.equals(organizationalUnit, abstractContract.organizationalUnit) && Objects.equals(dataFormat, abstractContract.dataFormat);
	}

	@Override
	public int hashCode() {
		return Objects.hash(organizationalUnit, dataFormat);
	}

	@Override
	public String toString() {
		return "{" +
			" organizationalUnit='" + getOrganizationalUnit() + "'" +
			", dataFormat='" + getDataFormat() + "'" +
			"}";
	}

}
