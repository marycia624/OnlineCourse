package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.Theory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TheoryRepository extends JpaRepository<Theory, BigInteger> {
}
