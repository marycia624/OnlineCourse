package com.avdeeva.web.application.onlinecourse.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "theory")
@Getter
@Setter
public class Theory {

    @Id
    @GeneratedValue
    private BigInteger id;

    private Integer number;

    private String text;

}
