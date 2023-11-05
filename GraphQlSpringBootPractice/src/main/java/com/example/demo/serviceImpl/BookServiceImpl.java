package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo repo;

	@Override
	public List<Book> listOfBooks() {
		return repo.findAll();
	}

	@Override
	public Book findById(int id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
	}

	@Override
	public Book createBook(Book book) {
		return repo.save(book);
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book existingBook = repo.findById(id).orElse(null);

		if (existingBook != null) {
			// Update the fields of the existing book with the values from the updatedBook
			existingBook.setTitle(book.getTitle());
			existingBook.setDescp(book.getDescp());
			existingBook.setAuthor(book.getAuthor());
			existingBook.setPrice(book.getPrice());
			existingBook.setPages(book.getPages());

			return repo.save(existingBook);
		} else {
			return null; // Book not found
		}
	}

}
