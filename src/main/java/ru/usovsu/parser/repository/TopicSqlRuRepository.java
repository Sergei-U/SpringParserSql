package ru.usovsu.parser.repository;

import org.springframework.data.repository.CrudRepository;
import ru.usovsu.parser.entity.TopicSqlRu;

import java.util.Optional;

/**
 *
 */
public interface TopicSqlRuRepository extends CrudRepository<TopicSqlRu, Long> {
    @Override
    Optional<TopicSqlRu> findById(Long aLong);

}
