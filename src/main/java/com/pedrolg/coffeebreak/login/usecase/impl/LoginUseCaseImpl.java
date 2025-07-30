package com.pedrolg.coffeebreak.login.usecase.impl;

public class LoginUseCaseImpl {
    public LoginGenerator authenticate(LoginRequest login) throws Exception {

        var loginDetails = userRepository.findByEmail(login.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean cb = cryptPassword.matches(login.password(), loginDetails.getPassword());

        if (!cb) {
            throw new PasswordAndUsernameIncorrectException();
        }
        var loginResponse = Login.builder()
                .id(loginDetails.getId().toString())
                .email(loginDetails.getEmail())
                .roles(List.of(Role.fromStringToEnum(loginDetails.getRoles())))
                .build();

        var jwtToken = generateTokenUseCase.execute(loginResponse);

        return LoginGenerator.builder()
                .userId(loginResponse.getId())
                .expirationTime(LocalDateTime.ofInstant(generateTokenUseCase.genExpirationDate(), ZoneId.systemDefault()))
                .token(jwtToken)
                .build();
    }
}
