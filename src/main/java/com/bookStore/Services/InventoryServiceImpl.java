package com.bookstore.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.BookStore.App.exception.InventoryException;
//import com.BookStore.App.model.inventory;
//import com.bookstore.Model.Book;
import com.bookstore.Model.Inventory;
import com.bookstore.Repository.InventoryRepository;


@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Inventory getBookById(int bookId) {
		Optional<Inventory> inventory = this.inventoryRepository.findById(bookId);
		
		if(inventory.isPresent()) {
			return inventory.get();
			}else {
				throw new NullPointerException();
				
			}
	    }
		
	
	/*public Inventory getBookByName(String bookName) {
		Optional<Inventory> inventory = this.inventoryRepository.findByBookName(bookName);
		
		if(inventory.isPresent()) {
			return inventory.get();
		}else {
			throw new NullPointerException();
		}
		
	}*/
	
	@Override
	public List<Inventory> getByBookName(String bookName) {
		List<Inventory> invBook = this.inventoryRepository.getByBookName(bookName);
		for(Inventory in : invBook) {
			if(in.getBookName().isEmpty()) {
				throw new NullPointerException();
			}
		}
		return invBook;
	}
	
	/*@Override
	public List<Inventory> getBookByAuthor(String author) {
		List<Inventory> inventory = this.inventoryRepository.getByBookAuthor(author);
		for(Inventory in : inventory) {
			if(in.getAuthor().isEmpty()) {
				throw new NullPointerException();
			}
		}
		return inventory;
	}*/
	
		
		/*if(inventory.isPresent()) {
			return inventoryRepository.findAll();
		}else {
			throw new NullPointerException();
		}
		
		
		
		
		/*public List<Inventory> getInventoryByBookName(String bookName)
		{
			List<Inventory> bookList=inventoryrepo.findInventoryByBookName(bookName);
			for (Inventory inventory : bookList) {
				if(inventory.getBookCount()==0)
					System.out.println("BOOK "+ inventory.getClassId()+" OUT OF STOCK");
			}
			return bookList;
		}
		//if()
		
		//for(Inventory i:)
		
	/*	if(inventory.isPresent()) {
			return inventory.get();
		}else {
			throw new NullPointerException();
		} */
	
	
 /*	public Inventory addBooks(Inventory in) {
		return inventoryRepository.save(in);
	}*/
	
	public Inventory updateBooks(Inventory in) {
		 Inventory inObj = getBookById(in.getBookId());
		 
		 inObj.setBookId(in.getBookId());
		 inObj.setCopies(in.getCopies());
		 inObj.setBookName(in.getBookName());
		 inObj.setAuthor(in.getAuthor());
		 
		 return this.inventoryRepository.save(in);		 
	}
	
	/*public void updateBookCount(Book book, int action){
        int bookId = book.getBookId();
        Optional<Inventory> inventory = this.inventoryRepository.findByBookId(bookId);
        if(inventory.isPresent()){
            Inventory in = inventory.get();
            in.setBookId(in.getBookId());
            updateBooks(in);
        }else{
            Inventory in = new Inventory(); 
            in.setBookId(book.getBookId());
            in.setBookName(book.getBookName());
          //  inv.setPrice(book.getBookPrice());
            addbooks(in);
        }
    }
	*/
	
	@Override
	public List<String> sortByLikes(){
		List<String> likes=new ArrayList<>();
		List<Inventory> in =this.inventoryRepository.sortByLikes();
		for(Inventory i:in) {
			likes.add(i.toString());
		}
		
		return likes;
	}
	
	public int getBookStock(int bookId){
        return getBookById(bookId).getCopies();
    }


	@Override
	public Inventory addbooks(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}


	@Override
	public List<Inventory> getList() {
               return (List<Inventory>) this.inventoryRepository.findAll();
	}


	@Override
	public List<String> sortbydate() {
		List<String> date=new ArrayList<>();
		List<Inventory> in=this.inventoryRepository.sortbydate();
		for(Inventory i:in) {
			date.add(i.toString());
		}
		return date;
	}


	/*@Override
	public Inventory updateinv(Inventory inventory) {
		Optional<Inventory> inObj=this.inventoryRepository.findById(inventory.getBookId());
		
		if(inObj.isPresent()) {
			Inventory upInv=inObj.get();
			upInv.setBookName(inventory.getBookName());
			upInv.setCategory(inventory.getCategory());
			upInv.setAvailability(inventory.getAvailability());
			upInv.setUnitprice(inventory.getUnitprice());
			invupdate.setLikes(inventory.getLikes());
			invupdate.setDateadded(inventory.getDateadded());
			return this.inventoryrepo.save(invupdate);
		}
		else {
			 throw new InventoryException("Inventory didn't found with id" +inventory.getBookid());
		}
	}*/


	/*@Override
	public List<String> sortbylikes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> sortbydate() {
		// TODO Auto-generated method stub
		return null;
	}*/


	/*@Override
	public List<Inventory> getbookbyName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Inventory> getbookbyAuthor() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
