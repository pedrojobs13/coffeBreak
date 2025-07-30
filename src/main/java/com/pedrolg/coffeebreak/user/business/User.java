package com.pedrolg.coffeebreak.user.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class User {
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String password;
    private String accountType;
}
