package adt_reto0;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import adt_reto0.factory.*;

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
		String[] input = console.next().split(" ");
		return Arrays.stream(input)
			.mapToInt(p -> Integer.parseInt(p))
			.toArray();
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
		int[] param = {-1};
		while(option != 0) {
			this.greeter("Managing customers");
			option = this.optionPrinter(customerOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					param = getParams("Customer Id");
					CustomerDAFactory.getAccessCustomer().createCustomer(param[0]);
					break;
				case 2:
					param = getParams("Customer Id");
					CustomerDAFactory.getAccessCustomer().getCustomerData(param[0]);
					break;
				case 3:
					param = getParams("Customer Id");
					CustomerDAFactory.getAccessCustomer().listCustomerAccounts(param[0]);
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void accountManager() {
		int option = -1;
		int[] param = {-1};
		while(option != 0) {
			this.greeter("Managing accounts");
			option = this.optionPrinter(accountOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					param = getParams("Customer Id");
					AccountADFactory.getAccessAccount().createAccount(param[0]);
					break;
				case 2:
					param = getParams("Customer Id && Account Id");
					AccountADFactory.getAccessAccount().addClientToAccount(param[0], param[1]);
					break;
				case 3:
					param = getParams("Account Id");
					AccountADFactory.getAccessAccount().getAccountData(param[0]);
					break;
				default:
					System.out.println("Unknown option!");
					break;
			}
		}
	}

	private void movementManager() {
		int option = -1;
		int[] param = {-1};
		while(option != 0) {
			this.greeter("Managing movements");
			option = this.optionPrinter(movementOptions);
			switch(option) {
				case 0:
					break;
				case 1:
					param = getParams("Source Account && Destination Account && Ammount");
					MovementADFactory.getAccessMovement().registerMovement(param[0], param[1], param[2]);
					break;
				case 2:
					param = getParams("Account Id");
					MovementADFactory.getAccessMovement().getAccountMovements(param[0]);
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

