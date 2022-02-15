package sysglue.registry.entities;

import javax.persistence.Entity;


@Entity
public class SubscriptionContract extends AbstractContract {

	private static final long serialVersionUID = 1L;

	public String outChannel;

}
