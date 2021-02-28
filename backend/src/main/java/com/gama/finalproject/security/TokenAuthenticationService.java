package com.gama.finalproject.security;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gama.finalproject.model.Response;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class TokenAuthenticationService {

    private TokenAuthenticationService() {}

    // Tempo de expiração
    static final long EXPIRATION_TIME = 86400; // 1 dia
    static final String SECRET = "secret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, String usuario) {
        String jwt = JWT.create()
            .withClaim("usuario", usuario)
            .sign(Algorithm.HMAC256(SECRET));
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            try {
                String jwt = token.replace(TOKEN_PREFIX, "").trim();
                DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256(SECRET)).acceptExpiresAt(EXPIRATION_TIME).build().verify(jwt);
                String usuario = decodedJwt.getClaim("usuario").asString();
                if (usuario != null) {
                    return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
                }
            } catch (JWTVerificationException ex) {
                return null;
            }
        }
        return null;
    }

}
