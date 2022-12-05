package com.bookstore.Repository;

import java.util.List;
//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.BookStore.App.model.inventory;
import com.bookstore.Model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
	 /*Optional<Inventory> findByBookId(int bookId);
	 Optional<Inventory> findByBookName(String bookName);
	 Optional<Inventory> findByAuthor(String author);*/
	 
	 
		/* @Query(value="Select i.author from Inventory AS i GROUP BY i.author",nativeQuery = true)
	        List<Inventory> getBookByAuthor(String author);  	*/ 
	
	
	 @Query(value="Select * from Inventory i order by book_likes desc",nativeQuery = true)
		List<Inventory> sortByLikes();
	
	 
	 @Query(value="Select i from Inventory i where i.author",nativeQuery=true)
		List<Inventory> getByBookAuthor(String author);
	 
	 @Query(value="Select i from Inventory i where i.bookName",nativeQuery=true)
		List<Inventory> getByBookName(String bookName);
	 
	 @Query(value="Select * from inventory i order by dateadded desc",nativeQuery = true)
		List<Inventory> sortbydate();

}
