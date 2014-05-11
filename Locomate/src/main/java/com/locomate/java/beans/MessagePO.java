package com.locomate.java.beans;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MessagePO {
	private int MessageId;
	@ManyToOne
    @JoinColumn(name="username")
	private RegistrationPO From;
	private RegistrationPO To;
	private String Message;

}
