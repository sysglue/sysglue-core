package sysglue.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class SubscriptionContract extends AbstractContract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String outChannel;

	public SubscriptionContract() {
	}

	public SubscriptionContract(String outChannel) {
		this.outChannel = outChannel;
	}

	public String getOutChannel() {
		return this.outChannel;
	}

	public void setOutChannel(String outChannel) {
		this.outChannel = outChannel;
	}

	public SubscriptionContract outChannel(String outChannel) {
		this.outChannel = outChannel;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SubscriptionContract)) {
			return false;
		}
		SubscriptionContract subscriptionContract = (SubscriptionContract) o;
		return Objects.equals(outChannel, subscriptionContract.outChannel);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(outChannel);
	}

	@Override
	public String toString() {
		return "{" +
			" outChannel='" + getOutChannel() + "'" +
			"}";
	}

}
