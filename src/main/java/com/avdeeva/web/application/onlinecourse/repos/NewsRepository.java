package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NewsRepository extends JpaRepository<News, BigInteger> {

}
