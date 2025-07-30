package com.pedrolg.coffeebreak.user.business.usecase;

public interface CryptPassword {
    boolean matches(String value, String encodedValue);

    String encoder(String value);
}
