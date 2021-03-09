package ru.usovsu.parser.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usovsu.parser.entity.TopicSqlRu;

import java.util.Optional;

/**
 *
 */
@Repository

public interface TopicSqlRuRepository extends JpaRepository<TopicSqlRu, Long> {

    @Override
    Optional<TopicSqlRu> findById(Long id);


}
