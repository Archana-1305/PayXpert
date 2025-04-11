package com.java.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {
	 public static String getConnectionString(String fileName) {
	        ResourceBundle rb = ResourceBundle.getBundle(fileName);
	        return rb.getString("url");
	    }

}
