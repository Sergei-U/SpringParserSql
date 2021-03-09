package ru.usovsu.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.usovsu.parser.entity.TopicSqlRu;

import java.util.Optional;

/**
 *
 */
public interface TopicSqlRuRepository extends JpaRepository<TopicSqlRu, Long> {

    Optional<TopicSqlRu> findById(Long id);

}
