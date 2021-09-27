package ru.cherry.springhomework.service;

import ru.cherry.springhomework.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAllGenres();

    Genre addGenre(String name);

    Genre getGenre(String name);

    Optional<Genre> getGenreById(String id);

    Genre editGenre(Genre genre);

    boolean deleteGenre(String id);
}
