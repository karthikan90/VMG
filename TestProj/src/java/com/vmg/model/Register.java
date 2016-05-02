/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name="Register")
public class Register  implements Serializable{
        
        @Id
        @Column(name = "REGISTERID" )
        private int registerId;
        
        @Column(name = "FIRSTNAME")
        private String firstName;
        
        @Column(name = "LASTNAME")
	private String lastName;
        
        @Column(name = "EMAIL")
	private String email;
        
        @Column(name = "USERNAME")
	private String userName;
        
        @Column(name = "PASSWORD")
	private String password;
        
        @Column(name = "CONFIRMPASSWORD")
	private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }
    
    

    @Override
    public String toString() {
        return "Register{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword + '}';
    }
    
    
    
}
