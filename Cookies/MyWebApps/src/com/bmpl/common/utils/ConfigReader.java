package com.bmpl.common.utils;

import java.util.ResourceBundle;

public interface ConfigReader {
	public static final ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getCompanyName(){
		return rb.getString("companyname");
	}
}
