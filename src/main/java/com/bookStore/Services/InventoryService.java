package com.bookstore.Services;

import java.util.List;

import com.bookstore.Model.Inventory;

public interface InventoryService {
	
	Inventory addbooks(Inventory inventory);
	Inventory getBookById(int bookId);
	List<Inventory> getList();
	//List<Inventory> getbookbyName();
	List<Inventory> getBookByAuthor(String author);
	List<Inventory> getByBookName(String bookName);
	//Inventory updateinv(Inventory inventory);
	List<String> sortByLikes();
	List<String> sortbydate();

}
