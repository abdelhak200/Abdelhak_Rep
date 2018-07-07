package it.mysite.controller;

import it.mysite.business.IProductBusiness;
import it.mysite.dao.Product;
import it.mysite.dao.ProductImplDB;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

 @Controller
	public class ProductController {
		 
	 static final Logger logger = Logger.getLogger(ProductController.class);
	 
		 @Autowired
		 IProductBusiness business;
		 
		 @RequestMapping(value="/index")
		 public String pageIndex(Model model){
			 logger.info("model: "+model);
			 model.addAttribute("ListProducts", business.getAllProducts());
			 return "productAdded";
		 }
		 
		 @RequestMapping(value="/search", method = RequestMethod.POST)
		 public String pageSearch(Model model, @RequestParam Long idProduct){
			 List<Product> products = new ArrayList<Product>();
			 if(business.getProductById(idProduct)!=null){
				 products.add(business.getProductById(idProduct));
				 model.addAttribute("ListProducts", products);
				 model.addAttribute("idProduct", idProduct);
				 
			 }else if(idProduct==null){
				 model.addAttribute("ListProducts", business.getAllProducts());				 
			 }else{
				 products.add(business.getProductById(idProduct));
				 model.addAttribute("ListProducts", products);
				 model.addAttribute("NoAdded", "The product doesn't exist");
			 }
			 return "productAdded";
		 }
		 
		 @RequestMapping(value="/addProduct", method = RequestMethod.POST)
		 public String pageAdd(Model model, Product product){
			 if(product.getName().length()>0 && product.getDescription().length()>0){
			 business.addProduct(product);
			 model.addAttribute("ListProducts", business.getAllProducts());
			 model.addAttribute("Added", "The product was added succefully");
			 }else{
				 model.addAttribute("ListProducts", business.getAllProducts());
				 model.addAttribute("Added", "The product wasn't added");
			 }
			 return "productAdded";
		 }
		 
		 @RequestMapping(value="/newProduct", method = RequestMethod.POST)
		 public String newProduct(){
			 return "newProduct";
		 }
		 
		 @RequestMapping(value="/deleteProd", method = RequestMethod.GET)
		 public String deleteProd(Model model,@RequestParam Long id){
				 business.deleteProduct(id);
				 model.addAttribute("ListProducts", business.getAllProducts());
			 return "productAdded";
		 } 
		 
}
 
 
