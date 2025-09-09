package com.jspiders.ecommerceapp.operation;

import java.util.List;
import java.util.Scanner;
import com.jspiders.ecommerceapp.collection.UserCollection;
import com.jspiders.ecommerceapp.entity.User;

public class UserOperation {

	private static UserCollection userCollection = new UserCollection();

	public void addUser(Scanner scanner) {
		
		System.out.println("Enter user id");
		int id = 0;
		try {
		   id = scanner.nextInt();
						
		} catch (Exception e) {
			System.err.println("Invalid input type");
		//	exceptResolve(scanner);
		}
		
		 //System.out.println("Enter user id");
        //id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name");
		String name = scanner.nextLine();
		System.out.println("Enter user email");
		String email = scanner.nextLine();
		System.out.println("Enter user mobile number");
		long mobile = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter user password");
		String password = scanner.nextLine();
		System.out.println("Enter user role");
		String role = scanner.nextLine();
		User user = new User(id, name, email, mobile, password, role);
		List<User> users = userCollection.getUsers();
		users.add(user);
		System.out.println("User added");

	}

//	public int exceptResolve(Scanner scanner) {
	//	System.out.println("Invalid input type");
		//System.out.println("Enter user id again");
		//int id = scanner.nextInt();
		//return id;
//	}

	public void findAllUsers() {
		List<User> users = userCollection.getUsers();
		if (users.size() > 0) {
			for (User user : users) {
				System.out.println(user);
			}
		} else {
			System.out.println("Users not found");
		}
	}

	public User logIn(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Enter user email");
		String email = scanner.nextLine();
		System.out.println("Enter user password");
		String password = scanner.nextLine();
		List<User> users = userCollection.getUsers();
		User loggedInUser = null;
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				loggedInUser = user;
				break;
			}
		}
		return loggedInUser;
	}
	
	
	
	public void deleteUser(Scanner scanner) {
		System.out.println("Enter user ID to delete");
		int id = scanner.nextInt();
		List<User> users = userCollection.getUsers();
		User userToDelete =null;
		boolean val=false;
		for (User user : users) {
			if(user.getId()==id) {
				userToDelete=user;
				 val=true;
			}
		}
		if(val) {
			users.remove(userToDelete);
			System.out.println("User with id "+id+" is deleted!!");
		}
	}

	public void updateUser(Scanner scanner) {
			System.out.println("Enter user ID to update");
			int id = scanner.nextInt();
			List<User> users = userCollection.getUsers();
			
			for (User user : users) {
				if(user.getId()==id) {
					scanner.nextLine();
					System.out.println("Enter new user name");
					user.setName(scanner.nextLine());
					System.out.println("Enter new email");
					user.setEmail(scanner.nextLine());
					System.out.println("Enter new mobile number");
					user.setMobile(scanner.nextLong());
					scanner.nextLine();
					System.out.println("Enter new password");
					user.setPassword(scanner.nextLine());
					
					System.out.println("User details updated");
				}
				else {
					System.err.println("User not found!!");
				}
			}
		
	}

}