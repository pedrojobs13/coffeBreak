package com.pedrolg.coffeebreak.user.gateway;

import com.pedrolg.coffeebreak.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {
    @Override
    public void findByEmail(String email) {

    }
}
