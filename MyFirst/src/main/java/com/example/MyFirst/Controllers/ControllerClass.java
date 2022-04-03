package com.example.MyFirst.Controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyFirst.IProductService;
import com.example.MyFirst.beans.Products;
import com.example.MyFirst.beans.Response;

@RestController
public class ControllerClass {

@Autowired
IProductService productService;

@GetMapping(value="/products")
public List<com.example.MyFirst.beans.Products> getProducts(){
	List<com.example.MyFirst.beans.Products> products = productService.findAll();
	
	return products;
}


@PostMapping(path="/Add/{product}" , consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public List<com.example.MyFirst.beans.Products> Handler(HttpServletRequest request, @PathVariable String product){
	ResponseEntity<Response> response =null;
	System.out.println("Request Reached"+product);
	HashMap<String, String> cart = new HashMap<String, String>();
	List<com.example.MyFirst.beans.Products> products = productService.findAll();
	boolean status = products.contains(product);
	if(status) {
		cart.put("1", product);
		
	}
	return products;
}

@GetMapping(value="/view")
public List<com.example.MyFirst.beans.Products> viewProducts(){
	List<com.example.MyFirst.beans.Products> products = productService.findAll();
	
	return products;
}

@GetMapping(path="/Remove/{product}")
public List<com.example.MyFirst.beans.Products> removeProducts( @PathVariable String product){
	List<com.example.MyFirst.beans.Products> products = productService.findAll();
	boolean remove = products.remove(new Products(0, product, 0));
	
	return products;
}

@GetMapping(value="/Cost")
public double CostOfProducts(){
	double cost=0;

	return cost;
}

}
