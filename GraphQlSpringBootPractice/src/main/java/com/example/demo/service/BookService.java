package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {

	//add
	public Book add(Book book);

	//list of books get
	public List<Book> listOfBooks();

	//find by book id
	public Book findById(int id);

	// add all books
	public List<Book> addall(List<Book> books);

}
