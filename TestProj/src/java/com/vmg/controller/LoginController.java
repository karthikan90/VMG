package com.vmg.controller;


import com.google.gson.Gson;
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
import com.vmg.model.SubCategory;
import com.vmg.service.CategoryService;
import com.vmg.service.RegisterService;
import com.vmg.validator.LoginValidator;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            final RedirectAttributes redirectAttributes) {
            String userName = registerBean.getUserName();
            String password = registerBean.getPassword();
            String role = registerBean.getRole();
            
            HttpSession session = request.getSession(true);
        
            boolean isValidUser = registerService.isValidUser(userName, password,role);
            if (isValidUser) {
                session.setAttribute("userid", userName);
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", registerBean.getUserName());
                return new ModelAndView("loginsuccess");
            } else {
                redirectAttributes.addFlashAttribute("message","invalid");
                return new ModelAndView("redirect:/index.html");
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
                ProjectHelper projectHelper  = new ProjectHelper();
                Map<String, Object> model = new HashMap<String, Object>();
                List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
		model.put("categories",  categoryList);
		return new ModelAndView("Category",model);
        }
        
        @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView savecategory(HttpServletRequest request,@ModelAttribute("categoryBean") CategoryBean categoryBean,
            final RedirectAttributes redirectAttributes) {
             ProjectHelper projectHelper = new ProjectHelper();
                
             HttpSession session = request.getSession(true);
                if(categoryService.isExistCategory(categoryBean.getCategoryName())){
                     redirectAttributes.addFlashAttribute("isExist","existed");
                     redirectAttributes.addFlashAttribute("categoryAdded","Category Already Existed.. Please Enter Some Other One ");
                    return new ModelAndView("redirect:/Category.html");
                }else{
                    Category category = projectHelper.prepareModelForCategory(categoryBean);
                    categoryService.addCategory(category);
                    return new ModelAndView("redirect:/Category.html");
                }
        }
        
        @RequestMapping(value = "/subcategory", method = RequestMethod.GET)
	public ModelAndView subCategoryPage() {
                ProjectHelper projectHelper  = new ProjectHelper();
                Map<String, Object> model = new HashMap<String, Object>();
                List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
		model.put("categories",  categoryList);
		return new ModelAndView("subcategory",model);
        }
        
        @RequestMapping(value = "/saveSubCategories", method = RequestMethod.GET)
	public ModelAndView saveSubCategories(@RequestParam("categories") String categories,@RequestParam("category") String category,@RequestParam("temp") String temp1) {
            
            SubCategory subCategory = new SubCategory();
            
            JSONParser parser = new JSONParser();
            System.out.println(" === "+temp1);
            try{
                
                org.json.simple.JSONArray a = (org.json.simple.JSONArray) parser.parse(temp1);

            for (Object o : a) {
                org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) o;

                String name = (String) jsonObject.get("Category");
                System.out.println(name);

                String city = (String) jsonObject.get("SubCategory");
                System.out.println(city);
                
                org.json.simple.JSONObject list = (org.json.simple.JSONObject) jsonObject.get("list");
                    String brand = (String) list.get("brand");
                    System.out.println(brand);
                    String price = (String) list.get("price");
                    System.out.println(price);
                    String quantity = (String) list.get("Quantity");
                    System.out.println(quantity);
                    String measurement = (String) list.get("Measurement");
                    System.out.println(measurement);
                    System.out.println("===============================================");
            }
                
                String jsonString = categories;
                JSONObject jsonResult = new JSONObject(jsonString);
                JSONArray data = jsonResult.getJSONArray(category);
                for(int i = 0 ; i < data.length() ; i++) {
                    subCategory.setSubCategoryName(data.getString(i));
                    subCategory.setCategoryId(Integer.parseInt(category));
                    categoryService.addSubCategory(subCategory);
                     System.out.println(""+data.getString(i));
                 }
            }catch(Exception exception){
                System.out.println(" "+exception.getMessage());
            }
                ModelAndView modelAndView = new ModelAndView("success");
                modelAndView.addObject("response", "Your data has been saved successfully");
		return  modelAndView;
        }
        
        @RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView productPage() {
                ProjectHelper projectHelper  = new ProjectHelper();
                Map<String, Object> model = new HashMap<String, Object>();
                List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
		model.put("categories",  categoryList);
		return new ModelAndView("product",model);
        }
        
        @RequestMapping(value = "/getSubCategories", method = RequestMethod.GET)
	public ModelAndView getSubCategories(@RequestParam("categoryId") int categoryId) {
            System.out.println("id is "+categoryId);
             
                List<SubCategory> allSubCategories = categoryService.getAllSubCategories(categoryId);
                ModelAndView modelAndView = null;
                
                // create a new Gson instance
                Gson gson = new Gson();
                //o convert your list to json
                if(allSubCategories.size() > 0){
                    String jsonSubCategoriesList = gson.toJson(allSubCategories);
                    modelAndView = new ModelAndView("success");
                    modelAndView.addObject("response", jsonSubCategoriesList);
                }else{
                    modelAndView = new ModelAndView("success");
                    modelAndView.addObject("response", "No data has Displayed");
                }
                

                return  modelAndView;
        }
        
}
