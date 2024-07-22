package com.books.Books.security;


import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    private final static String JWT_KEY="nkfai4366nknq2ni9an269nfis2";
    private Algorithm algorithm= Algorithm.HMAC256(JWT_KEY);
}
