package ru.cherry.springhomework.dao;

import org.springframework.stereotype.Repository;
import ru.cherry.springhomework.domain.Author;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    List<Author> findAll();
    Author findAuthorByName(String name);
}
