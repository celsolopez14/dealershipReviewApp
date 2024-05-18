package com.dealershipreviewapp.dealershipreviewapp.security;

public class SecurityConstants {

    public static final String SECRET = "insert secret key here";
    public static final long EXPIRATION_TIME = 7200000; // 2hrs
    public static final String BEARER = "Bearer ";
    public static final String AUTH_ROUTE = "/authenticate";
    public static final String HEADER_AUTH = "Authorization";
}
