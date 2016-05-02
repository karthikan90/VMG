/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.validator;

/**
 *
 * @author Administrator
 */

import com.vmg.bean.RegisterBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
 
@Component
public class LoginValidator implements Validator 
{
 
    public boolean supports(Class clazz) {
        return RegisterBean.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) 
    {
        RegisterBean registerBean = (RegisterBean) target;
        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "user name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.confirmPassword", "confirmPassword is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
    }
 
}