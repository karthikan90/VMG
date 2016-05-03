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
        RegisterBean regBean = (RegisterBean) target;
        if(!regBean.getPassword().equals(regBean.getConfirmPassword())){
            errors.rejectValue("confirmPassword","notmatch.password");
        }
        
        if(regBean.getRegisterId() <=0){
            errors.rejectValue("registerId", "negativeValue", new Object[]{"'registerId'"}, "Register Id can't be negative");
        }
//
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email");
    }
 
}