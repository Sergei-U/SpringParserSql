package ru.usovsu.parser.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

/**
 *
 */
@Data
@Entity
@Table(name = "URLBYFIND")
@RequestMapping("/Urlbyfind")
public class UrlByFind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "URL")
    private String url;
}
