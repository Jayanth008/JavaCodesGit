package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@QueryMapping("allBooks")
	public List<Book> findAll() {
		return service.listOfBooks();
	}

	@QueryMapping("bookById")
	public Book bookById(@Argument int id) {
		return service.findById(id);
	}

	@MutationMapping("createBook")
	public Book createBook(@Argument("book") Book book) {
		return service.createBook(book);
	}

	@MutationMapping("updateBook")
	public Book updateBook(@Argument("id") int id, @Argument("book") Book book) {
		return service.updateBook(id, book);
	}

	@MutationMapping("deleteBook")
	public String deleteBook(@Argument int id) {
		return service.deleteBook(id);
	}
}
