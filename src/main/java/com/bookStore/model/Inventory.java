package com.bookstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book_inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	
	private String author;
	private String bookName;
	private int copies;
	private int booklikes;
	
	public Inventory() {
		
	}
	
	

	public Inventory(int bookId, String author, String bookName, int copies, int booklikes) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.bookName = bookName;
		this.copies = copies;
		this.booklikes = booklikes;
	}



	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBooklikes() {
		return booklikes;
	}

	public void setBooklikes(int booklikes) {
		this.booklikes = booklikes;
	}


}
