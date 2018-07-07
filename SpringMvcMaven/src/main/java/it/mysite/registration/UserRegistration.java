package it.mysite.registration;

import java.io.Serializable;

public class UserRegistration implements Serializable {

	     private Integer index;
	     private String userName;
	     private String password;
	     private String email;

	    public UserRegistration() {
	    }

	    public UserRegistration(String userName, String password, String email) {
	       this.userName = userName;
	       this.password = password;
	       this.email = email;
	    }
	   
	    public Integer getIndex() {
	        return this.index;
	    }
	    
	    public void setIndex(Integer index) {
	        this.index = index;
	    }
	    public String getUserName() {
	        return this.userName;
	    }
	    
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	    public String getPassword() {
	        return this.password;
	    }
	    
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getEmail() {
	        return this.email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
}
