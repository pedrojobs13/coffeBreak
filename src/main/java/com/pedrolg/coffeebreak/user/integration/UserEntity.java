package com.pedrolg.coffeebreak.user.integration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String accountType;
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private AddressEmbedded address;
}
