/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.helper;

import com.vmg.bean.CategoryBean;
import com.vmg.bean.RegisterBean;
import com.vmg.model.Category;
import com.vmg.model.Register;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohan Gandhi
 */
public class ProjectHelper {

    public Register prepareModel(RegisterBean registerBean) {
        Register register = new Register();
        register.setRegisterId(registerBean.getRegisterId());
        register.setFirstName(registerBean.getFirstName());
        register.setLastName(registerBean.getLastName());
        register.setUserName(registerBean.getUserName());
        register.setEmail(registerBean.getEmail());
        PasswordEncryptHelper encryptHelper = new PasswordEncryptHelper();
        register.setPassword(encryptHelper.getEncryptPassword(registerBean.getPassword()));
        register.setConfirmPassword(encryptHelper.getEncryptPassword(registerBean.getConfirmPassword()));
        return register;
    }

    public Category prepareModelForCategory(CategoryBean categoryBean) {
        Category category = new Category();
        category.setCategoryName(categoryBean.getCategoryName());
//        category.setCategoryId(categoryBean.getCategoryId());
//        categoryBean.setCategoryId(null);
        return category;
    }

    public List<CategoryBean> prepareListofBeanForCategory(List<Category> categories) {
        List<CategoryBean> categoryBeansList = null;
        if (categories != null && !categories.isEmpty()) {
            categoryBeansList = new ArrayList<CategoryBean>();
            CategoryBean categoryBean = null;
            for (Category category : categories) {
                categoryBean = new CategoryBean();
                categoryBean.setCategoryName(category.getCategoryName());
                categoryBean.setCategoryId(category.getCategoryId());
                categoryBeansList.add(categoryBean);
            }
        }
        return categoryBeansList;
    }

}
