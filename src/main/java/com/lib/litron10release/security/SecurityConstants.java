package com.lib.litron10release.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/auth/signup";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";

    public static final long EXPIRATION_TIME = 600_000_000;
}
