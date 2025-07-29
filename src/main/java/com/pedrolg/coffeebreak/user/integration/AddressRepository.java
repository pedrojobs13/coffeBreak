package com.pedrolg.coffeebreak.user.integration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEmbedded, Long> {
}
