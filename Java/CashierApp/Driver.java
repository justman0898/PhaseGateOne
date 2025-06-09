import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.Arrays;
public class Driver{
	public static void main(String[] args){
	CashierMachine customer1 = new CashierMachine();
	Scanner scanner = new Scanner(System.in);
		String name = null;
		String item = null;
		String quantity = null;
		String price = null;
		double discount = 0.0;
		double amount = 0.0;
		boolean isValid = true;
		System.out.println("Enter Customers Name:");
		name = scanner.nextLine();
		while(isValid){
			
			try{
				
				System.out.println("What did the customer buy?");
				item = scanner.nextLine();				
				System.out.println("How many pieces?");
				quantity = scanner.nextLine();
				Integer.parseInt(quantity);
				System.out.println("How much per unit?");
				price = scanner.nextLine();
				Double.parseDouble(price);
				customer1.addItem(item,quantity,price);
				boolean inAddMore = true;
				while(inAddMore){
					System.out.print("Add more Item?");
					String userInput = scanner.nextLine().toLowerCase();
					switch(userInput){
						case "yes" -> {
							
							System.out.println("What did the customer buy?");
							item = scanner.nextLine();							
							System.out.println("How many pieces?");
							quantity = scanner.nextLine();
							Integer.parseInt(quantity);
							System.out.println("How much per unit?");
							price = scanner.nextLine();
							Double.parseDouble(price);
							customer1.addItem(item,quantity,price);
							
						}
						case "no" -> {
							System.out.println("How much discount will  he get?");				
							discount = scanner.nextDouble();						
							customer1.setDiscount(discount);
							customer1.printFullReciept(name);
							amount = scanner.nextDouble();
							customer1.printFullFinalReciept(amount,name);
							inAddMore = false;
							isValid = false;
						}
						default -> {
							System.out.println("Yes/No");
						}
					}
				}
				
				
								
			}catch(NumberFormatException | InputMismatchException exception){
				System.out.println("We noticed you might hava inputed the wrong info, try again...");
				scanner.nextLine();				
			}
		}
		
				





	}



















}