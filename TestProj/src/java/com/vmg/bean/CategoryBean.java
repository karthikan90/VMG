/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.bean;

/**
 *
 * @author Mohan Gandhi
 */
public class CategoryBean {
    
    private Integer categoryId;
        
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    

    @Override
    public String toString() {
        return "CategoryBean{" + "categoryId=" + categoryId + ", firstName=" + categoryName + '}';
    }
    
    
}
