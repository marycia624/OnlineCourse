package com.avdeeva.web.application.onlinecourse.repos;

import com.avdeeva.web.application.onlinecourse.domain.Task;
import com.avdeeva.web.application.onlinecourse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, BigInteger> {
    List<Task> findByNumber(Integer number);

}
