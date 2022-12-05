package com.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.Book;

import com.bookstore.Services.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService bookservice;
	
	@GetMapping("/book")
	private ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok().body(this.bookservice.getBooks());
	}
	
	@GetMapping("/book/{bkId}")
	private Book getBookById(@PathVariable int bkId) {
		return this.bookservice.getBookById(bkId);
	}
	
	@PostMapping("/book")
    private ResponseEntity<Book> addBooks(@RequestBody Book bk) {
		return ResponseEntity.ok().body(this.bookservice.addBooks(bk));
		
	}
	
	@PutMapping("/book/{bkId}")
	private ResponseEntity<Book> updateBooks(@PathVariable int bkId, @RequestBody Book bk){
		bk.setBookId(bkId);
		return ResponseEntity.ok().body(this.bookservice.updateBooks(bk));		
	}

}
