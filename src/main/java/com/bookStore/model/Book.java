package com.bookstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_table")
public class Book {

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int bookId;
     
     
	 private String bookName;
	 
	 private String bookAuthor;
	 
	 private int price;
	 
	 private String bookCategory;
	 
	 public Book() {
		 
	 }
	 
	 
	 
	public Book(int bookId, String bookName, String bookAuthor, int price, String bookCategory) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
		this.bookCategory = bookCategory;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	 
	
}
