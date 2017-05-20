package com.quantifiedcare;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jlouns
 */
public class EmailDetailsForm implements EmailDetails {
	private String to;
	private String subject;
	private String body;

	@Override
	@Email
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	@NotEmpty
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	@NotEmpty
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
