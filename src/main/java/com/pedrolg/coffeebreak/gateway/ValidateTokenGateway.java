package com.pedrolg.coffeebreak.gateway;

import com.pedrolg.coffeebreak.config.Login;

public interface ValidateTokenGateway {
    Login execute(String token);
}
