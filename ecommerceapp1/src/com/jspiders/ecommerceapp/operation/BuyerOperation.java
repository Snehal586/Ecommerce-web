package com.jspiders.ecommerceapp.operation;

import java.util.List;
import java.util.Scanner;

import com.jspiders.ecommerceapp.collection.BuyerCollection;
import com.jspiders.ecommerceapp.entity.Buyer;
import com.jspiders.ecommerceapp.entity.Product;

public class BuyerOperation {
	
	private static BuyerCollection buyerCollection = new BuyerCollection();
	
	
	public void searchProduct(Scanner scanner) {
		
		// TODO Auto-generated method stub
	
	}
	
	
	

	public void addCart(Scanner scanner) {

		System.out.println("Enter product id");
		int id = scanner.nextInt();
		scanner.nextLine();
		Buyer cart = new Buyer();
		List<Product> product = BuyerCollection.getCart();
		
	}

}
