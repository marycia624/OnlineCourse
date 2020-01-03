package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CommentRepository extends JpaRepository<Comment, BigInteger> {

}
