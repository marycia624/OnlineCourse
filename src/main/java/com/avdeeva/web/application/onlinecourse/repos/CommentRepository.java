package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.Comment;
import com.avdeeva.web.application.onlinecourse.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
   Set<Comment> findByNews(News news);

   Set<Comment> findDistinctByNews(News news);
}
