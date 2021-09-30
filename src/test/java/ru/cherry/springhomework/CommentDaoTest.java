package ru.cherry.springhomework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.cherry.springhomework.dao.CommentRepository;
import ru.cherry.springhomework.domain.Book;
import ru.cherry.springhomework.domain.Comment;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class CommentDaoTest {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private MongoTemplate mt;

	@Test
	void insertComment() {
		Book book = mt.findById("1", Book.class);
		Comment comment = new Comment(book,"Comment-2");
		Comment comment1 = commentRepository.save(comment);
		assertNotNull(comment1);
	}

	@Test
	void getByBookId() {
		List<Comment> comments = commentRepository.findCommentByBookId("2");
		assertEquals(1, comments.size());
	}

}