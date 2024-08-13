package mylib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

 class User{
	
	private int id;
	private String name;
	private String contact;
	
	public User(int id, String name, String contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	
	//getters
	public int getID() {
		return id;
	}
	public String getNAme() {
		return name;
	}
	public String getContact() {
		return contact;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	@Override
	public String toString() {
		return id + " " + name + " " + contact;
	}
}

public class Lib {
	private static List<User> users = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("1.ADD");
			System.out.println("2.DELETE");
			System.out.println("3.SEARCH");
			System.out.println("4.UPDATE");
			System.out.println("5.Display");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice){
			case 1:
				add(scan);
				break;
			case 2:
				delete(scan);
				break;
			case 3:
				search(scan);
				break;
			case 4:
				update(scan);
				break;
				case 5:
					display(scan);
					break;
			}
			
		}while (choice != 0);
		

	}
	
	private static void add (Scanner scan) {
		System.out.println("Enter your ID: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter your Name: ");
		String name = scan.nextLine();
		System.out.println("Enter your Contact: ");
		String contact = scan.nextLine();
		
		User newUser = new User(id, name, contact);
		users.add(newUser);
		System.out.println("added succesfully!");
	}
	private static void delete (Scanner scan) {
		System.out.println("Enter desired id to delete: ");
		int id = scan.nextInt();
		
		Iterator<User> iterator = users.iterator();
		
		Boolean removed = false;
		while(iterator.hasNext()) {
			User user = iterator.next();
		
		if(user.getID() == id) {
			iterator.remove();
				removed = true;
				System.out.println("User with ID: " + id + "\thad been removed!");
				break;
			}
		}
		if(!removed) {
			System.out.println("User with ID: " + id + "\tnot found!");
		
		}
	}
	
	private static void search(Scanner scan) {
		System.out.println("Enter desired id to be searched: ");
		int id = scan.nextInt();
		scan.nextLine();
		Boolean found = false;
		
		for(User user : users) {
			if(user.getID() == id) {
				System.out.println("User found with the ID: " + id);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("User does not exist");
		}
	}
	private static void update(Scanner scan) {
		System.out.println("Enter desired id to be searched: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		User newUser = null;
		for(User user : users) {
			if(user.getID() == id) {
				newUser = user;
				break;
			}
		}
		if(newUser != null) {
			System.out.println("Enter your Name: ");
			String newName = scan.nextLine();
			System.out.println("Enter your Contact: ");
			String newContact = scan.nextLine();
			
			newUser.setName(newName);
			newUser.setName(newContact);
			System.out.println("User updated with success!");
		}else {
			System.out.println("User not found");
		}
	}
	private static void display(Scanner scan) {
		if(users.isEmpty()) {
			System.out.println("List is empty no users");
		}
		for(User user : users) {
		System.out.println("All users" + user);
		}
	}
	
	
}
