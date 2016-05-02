package com.vmg.controller;


import com.vmg.bean.CategoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmg.bean.RegisterBean;
import com.vmg.helper.ProjectHelper;
import com.vmg.model.Category;
import com.vmg.model.Register;
import com.vmg.service.CategoryService;
import com.vmg.service.RegisterService;
import com.vmg.validator.LoginValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
        
	@Autowired
	private CategoryService categoryService;
        
        @Autowired
        LoginValidator loginValidator;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveUserDetails(HttpServletRequest request,@ModelAttribute("registerBean") RegisterBean registerBean, 
			BindingResult result) {
                //Validation code
                loginValidator.validate(registerBean, result);

                //Check validation errors
                if (result.hasErrors()) {
                    return new ModelAndView("register");
                }
                
                ProjectHelper projectHelper = new ProjectHelper();
		Register register = projectHelper.prepareModel(registerBean);
                registerService.addUserDetails(register);
		return new ModelAndView("registersuccess");
	}
        
	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
        public ModelAndView isValidUser(HttpServletRequest request, @ModelAttribute("registerBean") RegisterBean registerBean,
            BindingResult result) {
            String userName = registerBean.getUserName();
            String password = registerBean.getPassword();
            String role = registerBean.getRole();
            
            HttpSession session = request.getSession(true);
            
            //Validation code
            loginValidator.validate(registerBean, result);
            //Check validation errors
                if (result.hasErrors()) {
                    return new ModelAndView("redirect:index.html");
                }
            boolean isValidUser = registerService.isValidUser(userName, password,role);
            if (isValidUser) {
                session.setAttribute("userid", userName);
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", registerBean.getUserName());
                return new ModelAndView("loginsuccess");
            } else {
                request.setAttribute("message", "Invalid credentials!!");
                session.setAttribute("userid", null);
                return new ModelAndView("loginsuccess");
            }

    }
        
        @RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
   
        @RequestMapping(value = "/logout" ,method = RequestMethod.GET)
        public ModelAndView logout() {

            return new ModelAndView("logout");
        }
        
        @RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		return new ModelAndView("register");
        }
        
        @RequestMapping(value = "/Category", method = RequestMethod.GET)
	public ModelAndView categoryPage(HttpServletRequest request,@ModelAttribute("categoryBean") CategoryBean categoryBean,
            BindingResult result) {
            String id = request.getParameter("id");
            ProjectHelper projectHelper  = new ProjectHelper();
                Map<String, Object> model = new HashMap<String, Object>();
                List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
		model.put("categories",  categoryList);
		return new ModelAndView("Category",model);
        }
        
        @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView savecategory(HttpServletRequest request,@ModelAttribute("categoryBean") CategoryBean categoryBean,
            BindingResult result) {
             ProjectHelper projectHelper = new ProjectHelper();
                Category category = projectHelper.prepareModelForCategory(categoryBean);
                categoryService.addCategory(category);
                return new ModelAndView("redirect:/Category.html");
        }
        
        @RequestMapping(value = "/subcategory", method = RequestMethod.GET)
	public ModelAndView subCategoryPage() {
		return new ModelAndView("subcategory");
        }
        
        @RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView productPage() {
		return new ModelAndView("product");
        }
        
}
