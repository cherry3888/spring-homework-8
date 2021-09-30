package ru.cherry.springhomework.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cherry.springhomework.domain.Genre;
import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, String> {
    List<Genre> findAll();
    Genre findGenreByName(String name);
}
