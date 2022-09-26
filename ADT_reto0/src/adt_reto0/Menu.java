package adt_reto0;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

	private Scanner console = new Scanner(System.in);

	private List<String> managerOptions =
		new ArrayList<String>(List.of(
			"Manage customers"
			,"Manage accounts"
			,"Manage movements"
		)
	);
		
	private List<String> customerOptions =
		new ArrayList<String>(List.of(
			"Create customer"
			,"Check customer data"
			,"List the customer's accounts"
		)
	);
		
	private List<String> accountOptions =
		new ArrayList<String>(List.of(
			"Create account"
			,"Check account data"
			,"List the customers associated with account"
		)
	);
		
	private List<String> movementOptions =
		new ArrayList<String>(List.of(
			"Make a movement"
			,"Check account's movements"
		)
	);
		
	private void print(String s, int n) {
		System.out.println(n + ".: " + s);
	}
	
	private void greeter(String s) {
		System.out.println("\n\n" + s);
	}
		
	private int optionPrinter(List<String> options) {
		print("Exit", 0);
		options.stream()
			.forEach(p -> print(p, options.indexOf(p)+1));
		System.out.print("\nElige una opcion: ");
		return console.nextInt();
	}
	
	private int[] getParams(String s) {
		System.out.print("\nIntroduce the " + s + ": ");
		String input = console.next();
		//return new ArrayList<String>(List.of(input.split(" "))).stream()
			//.map(p -> p.parseInt());
		int[] result = {0};
		return result;
	}

	private void menuManager() {
		int option = -1;
		while(option != 0) {
			this.greeter("Main Menu");
			option = this.optionPrinter(managerOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					this.customerManager();
					break;
				case 2:
					this.accountManager();
					break;
				case 3:
					this.movementManager();
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void customerManager() {
		int option = -1;
		while(option != 0) {
			this.greeter("Managing customers");
			option = this.optionPrinter(customerOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					int param = getParams("Customer Id")[0];
					CustomerDAFactory.getAccessCustomer().createCustomer(param);
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void accountManager() {
		int option = -1;
		while(option != 0) {
			this.greeter("Managing accounts");
			option = this.optionPrinter(accountOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void movementManager() {
		int option = -1;
		while(option != 0) {
			this.greeter("Managing movements");
			option = this.optionPrinter(movementOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void start() {
		this.menuManager();
	}
	
}

