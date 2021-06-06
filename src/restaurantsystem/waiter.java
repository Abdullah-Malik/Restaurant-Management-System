/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

/**
 *
 * This class stores information for the waiter
 */
public class waiter {
    /**
    * Name of the waiter is stored in username 
    */
    private String username;
    /**
    * Password of the waiter is stored in password 
    */
    private String password;

    public waiter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
