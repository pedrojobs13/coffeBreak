package com.pedrolg.coffeebreak.user.business.usecase.impl;

import com.pedrolg.coffeebreak.user.business.usecase.CryptPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CryptPasswordImpl implements CryptPassword {
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(String value, String encodedValue) {
        return passwordEncoder.matches(value, encodedValue);
    }

    @Override
    public String encoder(String value) {
        return passwordEncoder.encode(value);
    }
}
