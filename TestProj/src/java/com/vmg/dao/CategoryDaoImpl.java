/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.dao;

import com.vmg.model.Category;
import com.vmg.model.SubCategory;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohan Gandhi
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }

    @Override
    public void addCategory(Category category) {
            System.out.println("category "+category);
        Serializable save = sessionFactory.getCurrentSession().save(category); 
    }

    @Override
    public boolean isExistCategory(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        //Query using Hibernate Query Language
        String SQL_QUERY = "from Category as c where c.categoryName=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0, categoryName);
        return query.list().size() > 0 ? true : false;
    }

    @Override
    public void addSubCategory(SubCategory subCategory) {
          System.out.println("category "+subCategory);
           sessionFactory.getCurrentSession().save(subCategory); 
    }
    
}
