package com.avdeeva.web.application.onlinecourse.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private BigInteger id;

    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    //private Date date;

    //private BigInteger news_id;

    public Comment () { }

    public Comment(String message, User user) {
        this.message = message;
        this.author = user;
    }
}
