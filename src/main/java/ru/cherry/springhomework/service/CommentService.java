package ru.cherry.springhomework.service;

import ru.cherry.springhomework.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment save(String bookId, String content);

    List<Comment> getByBookId(String id);
}
