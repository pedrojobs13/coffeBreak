package com.pedrolg.coffeebreak.config;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    COMPANY("FARMER");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    public static Role fromStringToEnum(String status) {
        for (Role ps : Role.values()) {
            if (ps.getType().equalsIgnoreCase(status)) {
                return ps;
            }
        }
        throw new IllegalArgumentException("Unknown Types: " + status);
    }

}
