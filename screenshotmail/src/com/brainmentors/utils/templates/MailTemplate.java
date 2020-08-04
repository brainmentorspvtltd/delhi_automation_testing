package com.brainmentors.utils.templates;

import java.util.ResourceBundle;

public interface MailTemplate {
	ResourceBundle rb = ResourceBundle.getBundle("messages");
	public static String getInfoTemplate() {
		return rb.getString("infomessage");
	}

}
