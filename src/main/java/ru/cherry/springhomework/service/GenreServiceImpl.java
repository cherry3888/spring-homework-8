package ru.cherry.springhomework.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cherry.springhomework.dao.GenreRepository;
import ru.cherry.springhomework.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    final private GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    @Override
    public Genre addGenre(String name) {
        return genreRepository.save(new Genre(name));
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(String name) {
        return genreRepository.findGenreByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Genre> getGenreById(String id) {
        return genreRepository.findById(id);
    }

    @Transactional
    @Override
    public Genre editGenre(Genre genre) {
        Optional<Genre> genreO = genreRepository.findById(genre.getId());
        if (genreO.isPresent()) {
            return genreRepository.save(genre);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean deleteGenre(String id) {
        Optional<Genre> genreO = genreRepository.findById(id);
        if (genreO.isPresent()) {
            genreRepository.delete(genreO.get());
            return true;
        }
        return false;
    }

}
