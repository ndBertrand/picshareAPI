package com.picshare.PicshareProject.security;

public class SecurityConstants {

	  	public static final String SECRET = "SecretKeyToGenJWTs";
	    public static final long EXPIRATION_TIME = 18000; // 5 minutes
	    public static final String TOKEN_PREFIX = "Bearer ";
	    public static final String HEADER_STRING = "Authorization";
	    public static final String SIGN_UP_URL = "/user/add";
}
