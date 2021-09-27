package ru.cherry.springhomework.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cherry.springhomework.domain.Book;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findBooksByTitle(String title);
    List<Book> findAll();
    Book findBookByTitleAndAuthorIdAndGenreId(String title, String authorId, String genreId);

}
