/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.service;

import com.vmg.dao.CategoryDao;
import com.vmg.model.Category;
import com.vmg.model.Product;
import com.vmg.model.SubCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan Gandhi
 */
@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public boolean isExistCategory(String categoryName) {
        return categoryDao.isExistCategory(categoryName);
    }
    
    @Override
    @Transactional
    public void addSubCategory(SubCategory subCategory) {
        categoryDao.addSubCategory(subCategory);
    }
    
    @Override
    @Transactional
    public void saveProductList(List<Product> productList) {
        categoryDao.saveProductList(productList);
    }

    @Override
    @Transactional
    public List<SubCategory> getAllSubCategories(int id) {
        return categoryDao.getAllSubCategories(id);
    }
    
}
