package com.pedrolg.coffeebreak.login.gateway;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pedrolg.coffeebreak.config.Login;
import com.pedrolg.coffeebreak.config.Role;
import com.pedrolg.coffeebreak.gateway.ValidateTokenGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ValidateTokenGatewayImpl implements ValidateTokenGateway {
    private final static String SECRET_KEY = "9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

    @Override
    public Login execute(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            final var jwt = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);

            return Login.builder()
                    .email(jwt.getSubject())
                    .id(jwt.getClaim("id").asString())
                    .roles(jwt.getClaim("roles").asList(Role.class))
                    .build();

        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException(exception.getMessage());
        }

    }
}
