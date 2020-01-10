package com.avdeeva.web.application.onlinecourse.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="tasks")
public class Task {

    @GeneratedValue
    @Id
    private BigInteger id;

    private Integer number;

    private Integer points;

    private String task;

    private String answer;

    private String image;

    @ManyToMany(mappedBy = "tasks")
    Set<User> users;
}
