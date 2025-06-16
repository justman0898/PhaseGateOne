import java.util.*;

public class PhoneBookApp{
	public static void main(String[] args){
		String firstName = null;
		String lastName = null;
		String phoneNumber = null;
		List<PhoneBook> contacts = new ArrayList<>();
		//List<String> phoneNos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("""
1. Add Contact
2. Remove contact
3. Find contact by First Name
4. Find contact by Last Name
5. Edit contact
0. End
		"""); 
		boolean inmainMenu = true;
		while(inmainMenu){
			int userInput = 0;
			try{
				System.out.println("Enter an option");
				userInput = scanner.nextInt();
				scanner.nextLine();
			}catch(InputMismatchException e){
				System.out.println("Choose a correct Input");
				scanner.nextLine();
			}
			switch(userInput){
				case 1 -> {
					System.out.print("Enter your First Name: ");
					firstName = scanner.nextLine();
					System.out.print("Enter your Last Name: ");
					lastName = scanner.nextLine();
					PhoneBook contact = new PhoneBook(firstName, lastName);
    					contacts.add(contact);
					boolean inAddPhoneNumber = true;
					while(inAddPhoneNumber){
						List<String> phoneNos = new ArrayList<>();
						System.out.println("Enter phoneNumber :");
					
						while(true){
							try{
								phoneNumber = scanner.nextLine();
								Long.parseLong(phoneNumber);
								phoneNos.add(phoneNumber);						
								break;
							}catch(InputMismatchException | NumberFormatException e){
								System.out.println("String detected");
								scanner.nextLine();
							}
						}
						System.out.println("Add more numbers(Yes/No)?");
						String reply = scanner.nextLine();
						switch(reply){
							case "yes" -> {
								inAddPhoneNumber = true;
							}
							case "no" -> {
								contact.addPhoneNumbers(phoneNos);
								inAddPhoneNumber = false;	
								
							}
						}
					}
				
				}
				case 4 -> {
					inmainMenu = false;


				}
			}













		}




















	}
}	