package ru.cherry.springhomework.service;

import org.springframework.stereotype.Service;
import ru.cherry.springhomework.dao.AuthorRepository;
import ru.cherry.springhomework.domain.Author;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    final private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author addAuthor(String id, String name) {
        return authorRepository.save(new Author(id, name));
    }

    @Override
    public Author getAuthor(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author editAuthor(Author author) {
        Optional<Author> authorO = authorRepository.findById(author.getId());
        if (authorO.isPresent()) {
            return authorRepository.save(author);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAuthor(String id) {
        Optional<Author> authorO = authorRepository.findById(id);
        if (authorO.isPresent()) {
            authorRepository.delete(authorO.get());
            return true;
        }
        return false;
    }

}
