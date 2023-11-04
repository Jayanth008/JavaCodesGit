package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

//@RestController
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

}
