package com.bookstore.Model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userid;
	   // @Column(name="userName")
	    private String userName;
	   // @Column(name="userMail")
	    private String userMail;
	   // @Column(name="userContact")
	    private int userContact;
	   // @Column(name="canBorrow")
	    private int canBorrow;
	    
	    public User() {
	    	
	    }
	    	    
	    public User(int userid, String userName, String userMail, int userContact, int canBorrow) {
			super();
			this.userid = userid;
			this.userName = userName;
			this.userMail = userMail;
			this.userContact = userContact;
			this.canBorrow = canBorrow;
		}
	     
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserMail() {
			return userMail;
		}
		public void setUserMail(String userMail) {
			this.userMail = userMail;
		}
		public int getUserContact() {
			return userContact;
		}
		public void setUserContact(int userContact) {
			this.userContact = userContact;
		}
		public int isCanBorrow() {
			return canBorrow;
		}
		public void setCanBorrow(int canBorrow) {
			this.canBorrow = canBorrow;
		}
	     
	    
	/*	@Override
		public String toString() {
			
		return super.toString();
		}
	*/	
}
