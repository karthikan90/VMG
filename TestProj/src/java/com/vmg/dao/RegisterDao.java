package com.vmg.dao;

import com.vmg.model.Register;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public interface RegisterDao {
    
    public void addUserDetails(Register register);
    
    public boolean isValidUser(String userName,String password,String role);
    
}
