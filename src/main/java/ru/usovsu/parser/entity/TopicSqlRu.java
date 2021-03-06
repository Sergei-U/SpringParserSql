package ru.usovsu.parser.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Data
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
        this.title = title;
        this.url = url;
    }

    public TopicSqlRu(StringBuilder resultMsgBodyElem, String dateVacancy) {
        this.msgVacancy = resultMsgBodyElem;
        this.date = dateVacancy;
    }

    public TopicSqlRu() {

    }
}

