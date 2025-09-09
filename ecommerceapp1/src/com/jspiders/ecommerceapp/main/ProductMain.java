package com.jspiders.ecommerceapp.main;

import java.util.Scanner;

import com.jspiders.ecommerceapp.entity.User;
import com.jspiders.ecommerceapp.operation.ProductOperation;

public class ProductMain {

	private static ProductOperation productOperation = new ProductOperation();

	public static void main(User user) {

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			//System.out.println("You have successfully logged in");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Enter 1 to add product \nEnter 2 to find all products \nEnter 3 to Delete the product \nEnter 4 to update the product \nEnter 5 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if (user.getRole().equalsIgnoreCase("SELLER")) {
					productOperation.addProduct(scanner);
				} else {
					System.out.println("Unauthorized access");
				}
				break;
			case 2:
				productOperation.findAllProducts();
				break;
			case 3:
				productOperation.deleteProduct(scanner);
				break;
			case 4:
				productOperation.updateProduct(scanner);
				break;
			case 5:
				flag = false;
				System.out.println("Thank you");
				
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	

	}

}