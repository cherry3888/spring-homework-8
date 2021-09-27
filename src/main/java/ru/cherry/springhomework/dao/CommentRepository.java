package ru.cherry.springhomework.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cherry.springhomework.domain.Comment;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, String> {
    List<Comment> findCommentByBookId(String bookId);
}
