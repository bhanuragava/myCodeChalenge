package com.example.MyFirst.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MyFirst.IProductService;
import com.example.MyFirst.beans.Products;

@Service
public class ProductService implements IProductService {

	@Override
	public List<Products> findAll() {
	
		ArrayList<Products> products = new ArrayList<Products>();
		products.add(new Products(100,"Mobile",9000.0));
		products.add(new Products(200,"Tab",12000.0));
		products.add(new Products(300,"TShirt",600.0));
		products.add(new Products(300,"Camera",15000.0));
		products.add(new Products(300,"Shoe",400.0));
		
		return products;
	}

}
