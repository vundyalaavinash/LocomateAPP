package com.locomate.java.beans;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RegistrationPO, Long> {

    public RegistrationPO findByEmail(String email);
}