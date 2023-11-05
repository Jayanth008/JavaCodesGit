package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {

	public List<Book> listOfBooks();

	public Book findById(int id);

	public Book createBook(Book book);

	public Book updateBook(int id, Book book);

	public String deleteBook(int id);

}
