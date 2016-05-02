/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.dao;

import com.vmg.model.Category;
import java.util.List;

/**
 *
 * @author Mohan Gandhi
 */
public interface CategoryDao {
    
    public List<Category> getAllCategories();
    
    public void addCategory(Category category);
    
}