package com.avdeeva.web.application.onlinecourse.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Set;

@Table(name="news")
@Entity
@Getter
@Setter
public class News {

    @GeneratedValue
    @Id
    private BigInteger id;

    private String text;

    public String getShotNews() {
        String result = this.text.substring(0, this.text.substring(0,150).lastIndexOf(" ")) + "...";

        if (!result.contains("</h1>")) {
            result = result + "</h1>";
        } else {
            result = result + "</p>";
        }
        return result;
    }
    public String getImage() {
        String result;
        String result2;
        if (this.text.contains("<img")) {
            result = this.text.substring(this.text.indexOf("<img"));
                  //  this.text.substring(this.text.indexOf("<img"))
                  //          .indexOf(">"));
            if (result.indexOf("style=") > 0)
            result2 = result.substring(0,result.indexOf("style=")) + "/>";
            else result2 = result.substring(0, result.indexOf(">") + 1);
        }
        else {
            result2 = "<img src=\"/img/e6263e33-97b5-49e4-a95e-9827cfd2f385.986.jpg \" />";
        }
        return result2;
    }

}
