package ru.cherry.springhomework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import ru.cherry.springhomework.dao.GenreRepository;
import ru.cherry.springhomework.domain.Genre;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class GenreDaoTest {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MongoTemplate mt;

    @Test
    void getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        assertEquals(3, genres.size());
    }

    @Test
    @DirtiesContext
    void insertGenre() {
        Genre genre = new Genre("4", "Genre-4");
        genreRepository.save(genre);
        Genre genre1 = mt.findById("4", Genre.class);
        assertNotNull(genre1);
    }

    @Test
    @DirtiesContext
    void updateGenre() {
        Genre genre = mt.findById("3", Genre.class);
        genre.setName("Genre-123");
        genreRepository.save(genre);
        Genre genre1 = mt.findById("3", Genre.class);
        assertNotNull(genre1);
        assertEquals(genre1.getName(), genre.getName());
    }

    @Test
    @DirtiesContext
    void deleteGenre() {
        Genre genre = mt.findById("1", Genre.class);
        genreRepository.delete(genre);
        Genre genre1 = mt.findById("1", Genre.class);
        assertNull(genre1);
    }

    @Test
    @DirtiesContext
    void getByName() {
        Genre genre = genreRepository.findGenreByName("Genre-1");
        assertNotNull(genre);
    }

}