/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmg.controller;

import com.vmg.model.Product;
import com.vmg.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
            
           Product product = null;
           
           List<Product> productList = new ArrayList<>();
           
            JSONParser parser = new JSONParser();
           
            try{
                
                org.json.simple.JSONArray a = (org.json.simple.JSONArray) parser.parse(productsList);
                
                for (Object o : a) {
                    
                product= new Product();
                
                org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) o;
             
                String productName = (String) jsonObject.get("productName");
                product.setProductName(productName);

                String productBrand = (String) jsonObject.get("productBrand");
                product.setProductBrand(productBrand);
                
                String productPrice = (String) jsonObject.get("productPrice");
                product.setProductPrice(Integer.parseInt(productPrice));
                
                String productQuantity = (String) jsonObject.get("productQuantity");
                product.setProductQuantity(Integer.parseInt(productQuantity));
                
                String measurement = (String) jsonObject.get("measurement");
                product.setProductMeasurement(measurement);
                
                String catId = (String) jsonObject.get("catId");
                product.setCatId(Integer.parseInt(catId.trim()));
                
                String subCatId = (String) jsonObject.get("subCatId");
                product.setSubCatId(Integer.parseInt(subCatId.trim()));
                
                productList.add(product);
                
            }
                
                if(productList.size() > 0){
                    productService.saveProductList(productList);
                }
            }catch(ParseException exception){
                System.out.println(" "+exception.getMessage());
            }
                ModelAndView modelAndView = new ModelAndView("success");
                modelAndView.addObject("response", "Your data has been saved successfully");
		return  modelAndView;
        }
    
}
