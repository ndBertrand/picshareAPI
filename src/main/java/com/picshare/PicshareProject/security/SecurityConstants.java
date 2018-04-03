package com.picshare.PicshareProject.security;

public class SecurityConstants {

    public final  static  String CLIENT_URL="http://192.168.43.249:4200/";

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/add";
}
