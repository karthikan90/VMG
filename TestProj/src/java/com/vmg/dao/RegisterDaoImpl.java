/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.dao;

import com.vmg.helper.PasswordEncryptHelper;
import com.vmg.model.Register;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao{
    
    @Autowired
	private SessionFactory sessionFactory;

    @Override
    public void addUserDetails(Register register) {
        System.out.println("encrypted password is "+register.getPassword());
       sessionFactory.getCurrentSession().save(register); 
    }

    @Override
    public boolean isValidUser(String userName, String password,String role) {
        Session session = sessionFactory.getCurrentSession();
        
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY ="from Register as r where r.userName=? and r.password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
                        PasswordEncryptHelper encryptHelper = new PasswordEncryptHelper();
			query.setParameter(1,encryptHelper.getEncryptPassword(password));
                        System.out.println("encrypted password is "+encryptHelper.getEncryptPassword(password));
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

//			session.close();
			return userFound;
        
    }
    
}
