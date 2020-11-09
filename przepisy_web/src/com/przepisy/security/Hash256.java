package com.przepisy.security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash256 {

    public static String HashPassword(String input){

	String hashed_password = null;
	
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(input.getBytes("utf8"));
	    hashed_password = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return hashed_password;
    }


}