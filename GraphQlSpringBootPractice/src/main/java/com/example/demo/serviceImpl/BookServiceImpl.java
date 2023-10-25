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
	public Book add(Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public List<Book> listOfBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Book not Found"));
	}

}
