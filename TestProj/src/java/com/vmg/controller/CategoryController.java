/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.controller;

import com.vmg.bean.CategoryBean;
import com.vmg.helper.ProjectHelper;
import com.vmg.model.Category;
import com.vmg.model.SubCategory;
import com.vmg.service.CategoryService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Mohan Gandhi
 */

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/Category", method = RequestMethod.GET)
    public ModelAndView categoryPage(HttpServletRequest request, @ModelAttribute("categoryBean") CategoryBean categoryBean,
            BindingResult result) {
        ProjectHelper projectHelper = new ProjectHelper();
        Map<String, Object> model = new HashMap<String, Object>();
        List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
        model.put("categories", categoryList);
        return new ModelAndView("Category", model);
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public ModelAndView savecategory(HttpServletRequest request, @ModelAttribute("categoryBean") CategoryBean categoryBean,
            final RedirectAttributes redirectAttributes) {
        ProjectHelper projectHelper = new ProjectHelper();

        HttpSession session = request.getSession(true);
        if (categoryService.isExistCategory(categoryBean.getCategoryName())) {
            redirectAttributes.addFlashAttribute("isExist", "existed");
            redirectAttributes.addFlashAttribute("categoryAdded", "Category Already Existed.. Please Enter Some Other One ");
            return new ModelAndView("redirect:/Category.html");
        } else {
            Category category = projectHelper.prepareModelForCategory(categoryBean);
            categoryService.addCategory(category);
            return new ModelAndView("redirect:/Category.html");
        }
    }

    @RequestMapping(value = "/subcategory", method = RequestMethod.GET)
    public ModelAndView subCategoryPage() {
        ProjectHelper projectHelper = new ProjectHelper();
        Map<String, Object> model = new HashMap<String, Object>();
        List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
        model.put("categories", categoryList);
        return new ModelAndView("subcategory", model);
    }

    @RequestMapping(value = "/saveSubCategories", method = RequestMethod.GET)
    public ModelAndView saveSubCategories(@RequestParam("categories") String categories) {

        SubCategory subCategory = new SubCategory();
        try {
            JSONArray data = new JSONArray(categories);
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonObject = data.getJSONObject(i);
                System.out.println(" " + jsonObject.get("catId"));
                subCategory.setCategoryId(Integer.parseInt((String) jsonObject.get("catId")));
                JSONArray jsonArray = jsonObject.getJSONArray("catNames");
                for (int j = 0; j < jsonArray.length(); j++) {
                    System.out.println(" " + jsonArray.getString(j));
                    subCategory.setSubCategoryName(jsonArray.getString(j));
                    categoryService.addSubCategory(subCategory);
                }
            }
        } catch (JSONException | NumberFormatException exception) {
            System.out.println(" " + exception.getMessage());
        }
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("response", "Your data has been saved successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView productPage() {
        ProjectHelper projectHelper = new ProjectHelper();
        Map<String, Object> model = new HashMap<String, Object>();
        List<CategoryBean> categoryList = projectHelper.prepareListofBeanForCategory(categoryService.getAllCategories());
        model.put("categories", categoryList);
        return new ModelAndView("product", model);
    }

    @RequestMapping(value = "/getSubCategories", method = RequestMethod.GET)
    public ModelAndView getSubCategories(@RequestParam("categoryId") int categoryId) {
        System.out.println("id is " + categoryId);

        List<SubCategory> allSubCategories = categoryService.getAllSubCategories(categoryId);
        ModelAndView modelAndView = null;

        // create a new ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (allSubCategories.size() > 0) {
                String arrayToJson = objectMapper.writeValueAsString(allSubCategories);
                modelAndView = new ModelAndView("success");
                modelAndView.addObject("response", arrayToJson);
            } else {
                modelAndView = new ModelAndView("success");
                modelAndView.addObject("response", "No data has Displayed");
            }
        } catch (IOException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelAndView;
    }

}
