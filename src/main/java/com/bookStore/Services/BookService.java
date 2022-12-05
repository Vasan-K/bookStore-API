package com.bookstore.Services;

import java.util.List;

import com.bookstore.Model.Book;

public interface BookService {
	
	Book addBooks(Book bk);
	Book updateBooks(Book bk);
	
	List<Book> getBooks();
	
	Book getBookById(int bookId);


}
