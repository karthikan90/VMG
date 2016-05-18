/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.dao;

import com.vmg.model.Product;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohan Gandhi
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void saveProductList(List<Product> productList) {
        System.out.println(" "+productList);
        for(Product product : productList){
            Serializable save = sessionFactory.getCurrentSession().save(product);
        }
    }
    
}
