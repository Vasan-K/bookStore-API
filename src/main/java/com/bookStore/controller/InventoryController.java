package com.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.Inventory;
import com.bookstore.Services.InventoryServiceImpl;

@RestController
public class InventoryController {
	
	@Autowired
	public InventoryServiceImpl inventoryservice;
	
	@GetMapping("/getbooks/byid/{bookid}")
	private Inventory getBookById(int bookId) {
		return this.inventoryservice.getBookById(bookId);		
	}
	
	@GetMapping("/sortlikes")
	private ResponseEntity<List<String>> sortByLikes(){
		return ResponseEntity.ok().body(this.inventoryservice.sortByLikes());		
	}

	@GetMapping("/getbooksBook/{bookName}")
	//@RequestMapping(value="/getbooksName/{bookName}",method = RequestMethod.GET)
	private ResponseEntity<List<Inventory>> getBookByName(@RequestParam(name="bookName") String bookName){
		return ResponseEntity.ok().body(this.inventoryservice.getByBookName(bookName)); 	
	}
	
	/*@GetMapping("/getbooksAuthor/{author}")
	private ResponseEntity<List<Inventory>> getBookByAuthor(@RequestParam(name="author") String author){
		return ResponseEntity.ok().body(this.inventoryservice.getBookByAuthor(author));
		}
	
	/*@GetMapping("/getbooksAuthor")
	//@RequestMapping(value ="/getbooksAuthor/{bookAuthor}", method = RequestMethod.GET)
	private Inventory getBookByAuthor(@RequestParam(name="author") String author){
		return this.inventoryservice.getBookByAuthor(author);	
	}*/
	
	@PostMapping("/postbooks")
	private ResponseEntity<Inventory> addBooks(@RequestBody Inventory in){
		return ResponseEntity.ok().body(this.inventoryservice.addbooks(in));
	}
 }
