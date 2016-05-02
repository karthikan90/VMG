/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.service;

import com.vmg.dao.RegisterDao;
import com.vmg.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service("registerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegisterServiceImpl implements RegisterService{
    
    @Autowired
    private RegisterDao registerDao;

    @Override
    @Transactional
    public void addUserDetails(Register register) {
        registerDao.addUserDetails(register);
    }

    @Override
    @Transactional
    public boolean isValidUser(String userName, String password,String role) {
        return registerDao.isValidUser(userName, password,role);
    }
    
}
