/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.service;

import com.vmg.model.Register;

/**
 *
 * @author Administrator
 */
public interface RegisterService {
    
    public void addUserDetails(Register register);
    
    public boolean isValidUser(String userName,String password,String role);
    
}
