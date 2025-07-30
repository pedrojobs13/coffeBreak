package com.pedrolg.coffeebreak.login.usecase.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.pedrolg.coffeebreak.config.Login;
import com.pedrolg.coffeebreak.config.Role;
import com.pedrolg.coffeebreak.login.usecase.GenerateTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class GenerateTokenUseCaseImpl implements GenerateTokenUseCase {
    private String secret = "9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

    @Override
    public String execute(Login login) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(login.getEmail())
                    .withClaim("roles", login.getRoles().stream().map(Role::getType).toList())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new Exception("Error generating token", e);
        }
    }

    @Override
    public Instant genExpirationDate() {
        LocalDateTime dateTime = LocalDateTime.now().plusHours(2);
        ZoneId zone = ZoneId.systemDefault();
        ZoneOffset offset = zone.getRules().getOffset(dateTime);
        return dateTime.toInstant(offset);
    }
}
