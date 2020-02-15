package com.cg.pms.service;

import java.util.List;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductService {
	
public boolean validateName(String employeeName);
public int addProduct (Product product) throws ProductException;
public Product  findProductById(int productId) throws ProductException;
public Product  deleteProductById(int productId) throws ProductException;
public List<Product > findAllProduct() throws ProductException;

}
