/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Prashanth
 */
@Entity
@Table(name="SubCategory")
public class SubCategory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sub_category_id")
    private int id;
    
    @Column(name = "sub_category_name")
    private String subCategoryName;
    
    @Column(name = "fk_category_id")
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "id=" + id + ", subCategoryName=" + subCategoryName + ", categoryId=" + categoryId + '}';
    }
}
