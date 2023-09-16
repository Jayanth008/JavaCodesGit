package com.bookauthor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookauthor.entity.BookAuthorEntity;

@Repository
public interface BookAuthorRepo extends JpaRepository<BookAuthorEntity, Integer> {

	List<BookAuthorEntity> findAllByOrderByBookIdDesc();

	List<BookAuthorEntity> findByAuthorName(String authorName);

}
