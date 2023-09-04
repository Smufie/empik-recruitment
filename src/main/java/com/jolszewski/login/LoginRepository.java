package com.jolszewski.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LoginRepository extends JpaRepository<UserLogin, String> {

    Optional<UserLogin> findByLogin(String login);
}
