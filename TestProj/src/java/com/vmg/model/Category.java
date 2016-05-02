/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mohan Gandhi
 */
@Entity
@Table(name="Category")
public class Category implements Serializable{
    
        @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "category_id")
        private Integer categoryId;
        
        @Column(name = "category_name")
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
            return "Category{" + "categoryId=" + categoryId + ", categoryName =" + categoryName + '}';
        }
        
        
}
