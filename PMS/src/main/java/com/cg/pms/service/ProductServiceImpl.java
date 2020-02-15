package com.cg.pms.service;

import java.util.List;
import java.util.Random;



import com.cg.pms.bean.Product;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.dao.ProductDaoMapImpl;
import com.cg.pms.exception.ProductException;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	public ProductServiceImpl()
	{
		productDao = new ProductDaoMapImpl();
	}
	@Override
	
	public boolean validateName(String productName) {
		boolean flag =false;
		flag=productName.matches("[a-zA-Z]+");
		return flag;
	}

	@Override
	public int addProduct(Product product) throws ProductException {
		String name = product.getProductName();
		boolean flag = validateName(name);
		if(!flag)
		{
			throw new ProductException("Name should contain only character");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		product.setProductId(id);
		id=productDao.addProduct(product);
		return id;
	}
	public Product findProductById(int productId) throws ProductException {
		String proid = String.valueOf(productId);
		boolean flag = proid.matches("[0-9]{4}");
		if(!flag)
		{
			throw new ProductException("Id should be 4 digit");
		}
		return productDao.findProductById(productId);
	}


	@Override
	public List<Product> findAllProduct() throws ProductException {
		return productDao.findAllProduct();
	}
	@Override
	public Product deleteProductById(int productId) throws ProductException {
		return productDao.deleteProductById(productId);
	}

}
