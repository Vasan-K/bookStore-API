package com.bookstore.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Model.Book;
import com.bookstore.Repository.BookRepository;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	

	@Override
	public Book addBooks(Book bk) {
		return bookRepository.save(bk);
	}

	@Override
	public Book updateBooks(Book bk) {
	   Optional<Book> bObj = this.bookRepository.findById(bk.getBookId());
	   
	   if(bObj.isPresent()) {
		    Book b = bObj.get();
		    b.setBookName(bk.getBookName());
		    b.setBookAuthor(bk.getBookAuthor());
		    b.setBookCategory(bk.getBookCategory());
		    b.setBookId(bk.getBookId());
		    b.setPrice(bk.getPrice());
		    return bookRepository.save(bk);
		  }else
		  {
			  throw new NullPointerException();
		  }
	}

	@Override
	public List<Book> getBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(int bookId) {
       Optional<Book> bObj = this.bookRepository.findById(bookId);
		
		if(bObj.isPresent()) {
			return bObj.get();
		}else
		{
			throw new NullPointerException();
		}		
	}

}
 