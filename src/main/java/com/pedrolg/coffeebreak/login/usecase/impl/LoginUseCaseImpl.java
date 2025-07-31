package com.pedrolg.coffeebreak.login.usecase.impl;

import com.pedrolg.coffeebreak.config.Login;
import com.pedrolg.coffeebreak.gateway.UserGateway;
import com.pedrolg.coffeebreak.login.model.LoginGenerator;
import com.pedrolg.coffeebreak.login.presentation.LoginDto;
import com.pedrolg.coffeebreak.user.business.usecase.CryptPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl {
    private final CryptPassword cryptPassword;
    private final UserGateway userGateway;

    public LoginGenerator authenticate(LoginDto login) throws Exception {

        var loginDetails = userGateway.findByEmail(login.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean cb = cryptPassword.matches(login.getPassword(), loginDetails.getPassword());


        var loginResponse = Login.builder()
                .email(loginDetails.getEmail())
                .build();

        var jwtToken = generateTokenUseCase.execute(loginResponse);

        return LoginGenerator.builder()
                .email(loginResponse.getId())
                .token(jwtToken)
                .build();
    }
}
