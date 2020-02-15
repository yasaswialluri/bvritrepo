package com.cg.pms.pl;

import java.util.List;
import java.util.Scanner;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;



public class Client {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductServiceImpl();

		int choice=0;

		Product product=null;
		List<Product> list = null;
		while(choice!=5)
		{
			System.out.println("1.Add Product");
			System.out.println("2. Search Product");
			System.out.println("3. Delete Product");
			System.out.println("4.list all Product");
			System.out.println("5.exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1: 
				
				System.out.println("Enter Name");
				scanner.nextLine();
				String name=scanner.nextLine();
				System.out.println("enter salary");
				double price = scanner.nextDouble();
				product = new Product();
				product.setProductName(name);
				product.setPrice(price);
				try {
					int id= productService.addProduct(product);
					System.out.println("Product Id = "+id);
				} catch (ProductException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter Product Id");
				int id=scanner.nextInt();
				try {
					product=productService.findProductById(id);
					System.out.println("Name = "+product.getProductName());
					System.out.println("price = "+product.getPrice());
				} catch (ProductException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter the Product Id");
				id=scanner.nextInt();
				try {
					productService.deleteProductById(id);
				} catch (ProductException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					list = productService.findAllProduct();
					for(Product pro:list)
					{
						id = pro.getProductId();
						name = pro.getProductName();
						price = pro.getPrice();
						System.out.println(id+" "+name+" "+price);
					}
				} catch (ProductException e) {
					System.err.println(e.getMessage());
				}

				break;
			case 5: System.out.println("Thank you");
			return;  
			}
		}
	}

}
