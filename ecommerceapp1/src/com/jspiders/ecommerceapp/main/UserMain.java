package com.jspiders.ecommerceapp.main;

import java.util.Scanner;

import com.jspiders.ecommerceapp.entity.User;
import com.jspiders.ecommerceapp.operation.UserOperation;

public class UserMain {

	private static UserOperation userOperation = new UserOperation();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("Enter 1 for sign up \nEnter 2 for log in as seller \nEnter 3 for log in as buyer \nEnter 4 to find all users \nEnter 5 for delete the user \nEnter 6 for update the user \nEnter 7 for exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				userOperation.addUser(scanner);
				break;
			case 2:
				User user = userOperation.logIn(scanner);
				
				if (user != null) {
					ProductMain.main(user);
				} else {
					System.out.println("Invalid email or password");
				}
				break;
			case 3:
				User user1 = userOperation.logIn(scanner);
				
				if (user1 != null) {
					BuyerMain.main(user1);
				} else {
					System.out.println("Invalid email or password");
				}
				break;
			case 4:
				userOperation.findAllUsers();
				break;
			case 5:
				userOperation.deleteUser(scanner);
				break;
			case 6:
				userOperation.updateUser(scanner);
				break;
			case 7:
				System.out.println("Thank you");
				flag = false;
				break;
			default:
				System.err.println("Invalid choice");
			}
		}
		scanner.close();

	}

}