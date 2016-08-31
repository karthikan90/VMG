/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.controller;

import com.vmg.model.Product;
import com.vmg.service.ProductService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mohan Gandhi
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/saveProductDetails", method = RequestMethod.GET)
	public ModelAndView saveProductDetails(@RequestParam("productsList") String productsList)  {
            
           List<Product> productList = new ArrayList<>();
           
            ObjectMapper objectMapper = new ObjectMapper();
            
           
            try{
                 JSONArray jsonArray = new JSONArray(productsList);
                 for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Product product = objectMapper.readValue(jsonObject.toString(), Product.class);
                    productList.add(product);
                }
             
                if(!productList.isEmpty()){
                    productService.saveProductList(productList);
                }
            } catch (JSONException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
                ModelAndView modelAndView = new ModelAndView("success");
                modelAndView.addObject("response", "Your data has been saved successfully");
		return  modelAndView;
        }
    
}
