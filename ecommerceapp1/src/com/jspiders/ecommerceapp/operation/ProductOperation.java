package com.jspiders.ecommerceapp.operation;

import java.util.List;
import java.util.Scanner;

import com.jspiders.ecommerceapp.collection.ProductCollection;
import com.jspiders.ecommerceapp.entity.Product;


public class ProductOperation {

	private static ProductCollection productCollection = new ProductCollection();

	public void addProduct(Scanner scanner) {

		System.out.println("Enter product id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter product title");
		String title = scanner.nextLine();
		System.out.println("Enter product description");
		String description = scanner.nextLine();
		System.out.println("Enter product price");
		double price = scanner.nextDouble();
		System.out.println("Enter product sale status");
		String status = scanner.next();
		boolean sold = false;
		if (status.equals("true")) {
			sold = true;
		}
		Product product = new Product(id, title, description, price, sold);
		List<Product> products = productCollection.getProducts();
		products.add(product);
		System.out.println("Product added");
	}

	public void findAllProducts() {

		List<Product> products = productCollection.getProducts();
		if (products.size() > 0) {
			for (Product product : products) {
				System.out.println(product);
			}
		} else {
			System.out.println("Products not found");
		}

	}

	public void deleteProduct(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter product ID to delete");
		int id = scanner.nextInt();
		List<Product> products = productCollection.getProducts();
		Product productToDelete =null;
		boolean val=false;
		for (Product product : products) {
			if(product.getId()==id) {
				productToDelete = product;
				 val=true;
			}
		}
		if(val) {
			products.remove(productToDelete);
			System.out.println("Product with id "+id+" is deleted!!");
		}
		
	}

	public void updateProduct(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter product ID to update");
		int id = scanner.nextInt();
		List<Product> products = productCollection.getProducts();
		
		for (Product product : products) {
			if(product.getId()==id) {
				scanner.nextLine();
				System.out.println("Enter new product title");
				product.setTitle(scanner.nextLine());
				System.out.println("Enter new description");
				product.setDescription(scanner.nextLine());
				System.out.println("Enter new product price");
				product.setPrice(scanner.nextDouble());
				scanner.nextLine();
				System.out.println("Enter new Sold Status");
				product.setSold(scanner.nextBoolean());
				
				System.out.println("product details updated");
			}
			else {
				System.err.println("product not found!!");
			}
		}
	
		
	}

}