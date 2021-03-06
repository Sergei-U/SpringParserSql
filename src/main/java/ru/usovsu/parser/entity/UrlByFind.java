package ru.usovsu.parser.entity;

import lombok.Data;
import javax.persistence.*;

/**
 *
 */
@Data
@Entity
public class UrlByFind {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String url;
}
