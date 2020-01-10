package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    User findByLogin (String login);

    User findByEmail(String email);

    User findByActivationCode(String code);
}
