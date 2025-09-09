package com.jspiders.ecommerceapp.main;

import java.util.Scanner;

import com.jspiders.ecommerceapp.entity.User;
//import com.jspiders.ecommerceapp.operation.BuyerOperation;
import com.jspiders.ecommerceapp.operation.ProductOperation;


public class BuyerMain {

//	private static BuyerOperation buyerOperation = new BuyerOperation();
	private static ProductOperation productOperation = new ProductOperation();
	

	public static void main(User user1) {

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println("Enter 1 to Find all products \nEnter 2 to search the product \nEnter 3 to add to cart \nEnter 4 to buy the product  \nEnter 5 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if (user1.getRole().equalsIgnoreCase("buyer")) {
					productOperation.findAllProducts();
				} else {
					System.out.println("Unauthorized access");
				}
				break;
//			case 2:
//				
//				break;
//			case 3:
//				buyerOperation.deleteProduct(scanner);
//				break;
//			case 4:
//				buyerOperation.updateProduct(scanner);
//				break;
			case 5:
				flag = false;
				System.out.println("Thank you");
				
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	
			scanner.close();
	}

}