package ru.cherry.springhomework.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.mongodb.client.MongoDatabase;
import ru.cherry.springhomework.domain.Author;
import ru.cherry.springhomework.domain.Book;
import ru.cherry.springhomework.domain.Comment;
import ru.cherry.springhomework.domain.Genre;

@ChangeLog
public class DatabaseChangeLog {

    private Author author1;
    private Author author2;
    private Author author3;
    private Genre genre1;
    private Genre genre2;
    private Genre genre3;
    private Book book1;
    private Book book2;
    private Book book3;
    private Comment comment1;
    private Comment comment2;
    private Comment comment3;


    @ChangeSet(order = "000", id = "dropDb", author = "victor", runAlways = true)
    public void dropDb(MongoDatabase db) {
        System.out.println("dropDB - 001");
        db.drop();
    }

    @ChangeSet(order = "001", id = "insertAuthors", author = "Victor", runAlways = true)
    public void insertAuthors(MongockTemplate template) {
        author1 = template.save(new Author("1", "Author-1"));
        author2 = template.save(new Author("2", "Author-2"));
        author3 = template.save(new Author("3", "Author-3"));
    }

    @ChangeSet(order = "002", id = "insertGenres", author = "Victor", runAlways = true)
    public void insertGenres(MongockTemplate template) {
        genre1 = template.save(new Genre("1", "Genre-1"));
        genre2 = template.save(new Genre("2", "Genre-2"));
        genre3 = template.save(new Genre("3", "Genre-3"));
    }

    @ChangeSet(order = "003", id = "insertBooks", author = "Victor", runAlways = true)
    public void insertBooks(MongockTemplate template) {
        book1 = template.save(new Book("1", "Book-1", author1, genre1));
        book2 = template.save(new Book("2", "Book-2", author2, genre2));
        book3 = template.save(new Book("3", "Book-3", author3, genre3));
    }

    @ChangeSet(order = "004", id = "insertComments", author = "Victor", runAlways = true)
    public void insertComments(MongockTemplate template) {
        template.save(new Comment("1", "Good", book1));
        template.save(new Comment("2", "Bad", book2));
        template.save(new Comment("3", "Normal", book3));
    }

}
