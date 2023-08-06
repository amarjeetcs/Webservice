package com.api.book.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.api.book.dao.BookRepository;
import com.api.book.entity.Book;

@Service

public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {

		Book book = null;
		try {

			book = this.bookRepository.findById(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return book;
	}

	public Book addBook(Book b) {
		Book result = bookRepository.save(b);

		return result;
	}

	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);

	}

	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
	}
}
