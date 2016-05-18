/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.service;

import com.vmg.model.Product;
import java.util.List;

/**
 *
 * @author Mohan Gandhi
 */
public interface ProductService {
    
    public void saveProductList(List<Product> productList);
    
}
