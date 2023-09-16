package com.bookauthor.service;

import java.util.List;

import com.bookauthor.entity.BookAuthorEntity;

public interface BookAuthorService {
	List<BookAuthorEntity> allAuthorList();

	void addAuthor(BookAuthorEntity model);

	void saveAuthor(BookAuthorEntity model);

	BookAuthorEntity findAuthorById(int bookid);

	void updateAuthor(BookAuthorEntity entity);

	void deleteAuthor(int bookid);

	List<BookAuthorEntity> testing();

	List<BookAuthorEntity> findbyAuthorName(String authorName);

}
