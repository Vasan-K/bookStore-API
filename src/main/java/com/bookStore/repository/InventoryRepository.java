package com.bookstore.Repository;

import java.util.List;
//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.BookStore.App.model.inventory;
import com.bookstore.Model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
	 /*Optional<Inventory> findByBookId(int bookId);
	 Optional<Inventory> findByBookName(String bookName);
	 Optional<Inventory> findByAuthor(String author);*/
	 
	 
		/* @Query(value="Select i.author from Inventory AS i GROUP BY i.author",nativeQuery = true)
	        List<Inventory> getBookByAuthor(String author);  	*/ 
	
	
	 @Query(value="SELECT * FROM Inventory i order by booklikes desc",nativeQuery = true)
		List<Inventory> sortByLikes();
	 
	 @Query(value="SELECT i FROM Inventory i where i.author=?1",nativeQuery=true)
		List<Inventory> getByBookAuthor(@Param("author") String author);
	 
	 @Query(value="SELECT i FROM Inventory i where i.bookName=?1",nativeQuery=true)
		List<Inventory> getBybookName(@Param("bookName") String bookName);
	 
	 @Query(value="SELECT * FROM Inventory i order by dateadded desc",nativeQuery = true)
		List<Inventory> sortbydate();

}
