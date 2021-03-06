package ru.usovsu.parser.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 */

@Table(name = "TOPICSQLRU")
@Entity
public class TopicSqlRu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID")
    private Long id;
    @Column(name = "TITLE")
    @ApiModelProperty(value = "наименование вакансии")
    private String title;
    @Column(name = "URL")
    @ApiModelProperty(value = "URL вакансии")
    private String url;
    @Column(name = "MSGVACANCY")
    @ApiModelProperty(value = "Описание вакансии")
    private StringBuilder msgVacancy;
    @Column(name = "DATE")
    @ApiModelProperty(value = "Дата размещения вакансии")
    private String date;



    public TopicSqlRu(String title, String url) {
        this.title=title;
        this.url = url;
    }

    public TopicSqlRu(StringBuilder resulMsgBodyElem, String dateVacancy) {
        this.msgVacancy=resulMsgBodyElem;
        this.date=dateVacancy;
    }

    public TopicSqlRu() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StringBuilder getMsgVacancy() {
        return msgVacancy;
    }

    public void setMsgVacancy(StringBuilder msgVacancy) {
        this.msgVacancy = msgVacancy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicSqlRu that = (TopicSqlRu) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(url, that.url) && Objects.equals(msgVacancy, that.msgVacancy) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url, msgVacancy, date);
    }
}
