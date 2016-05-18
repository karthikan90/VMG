/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.service;

import com.vmg.dao.ProductDao;
import com.vmg.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan Gandhi
 */
@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{
    
     @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public void saveProductList(List<Product> productList) {
        productDao.saveProductList(productList);
    }
    
}