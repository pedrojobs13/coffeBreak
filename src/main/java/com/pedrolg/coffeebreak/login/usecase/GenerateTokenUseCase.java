package com.pedrolg.coffeebreak.login.usecase;

import com.pedrolg.coffeebreak.config.Login;

import java.time.Instant;

public interface GenerateTokenUseCase {
    String execute(Login login) throws Exception;

    Instant genExpirationDate();
}
