package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// Get list of book
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getAllBook();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);

	}

	// Get single Book
	@GetMapping("/book")
	public Book getBook() {
		Book book1 = new Book();
		book1.setId(100);
		book1.setTitle("Java Edition in Easy way");
		book1.setAuthor("Hira Singh");
		return book1;
	}

	// Get book by id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook1(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}

	// Add the book into list
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// Delete the book by id
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBoo(@PathVariable("bookId") int bookId) {
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	// Update the book by id
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		try {
			this.bookService.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		

	}

}
