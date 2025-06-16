import java.util.*;
import java.util.stream.*;

public class PhoneBookFunctions{
	public static void removeContact(List<PhoneBook> contacts, String name){
		IntStream.range(0, contacts.size())			
			.filter(index -> contacts.get(index).getFirstName().equalsIgnoreCase(name))
			.findFirst()
			.ifPresent(contact -> contacts.remove((int)contact));
	}
	public static String searchContactFirstName(List<PhoneBook> contacts, String firstname){
		String message = contacts.stream()
					.filter(contact -> contact.getFirstName().equalsIgnoreCase(firstname))
					.map(contact -> contact.getFirstName()+ "\n"+contact.printPhoneNumber())
					.collect(Collectors.joining("\n"));
		return message;
	}
	public static String searchContactLastName(List<PhoneBook> contacts, String lastname){
		String message = contacts.stream()
					.filter(contact -> contact.getLastName().equalsIgnoreCase(lastname))
					.map(contact -> contact.getLastName()+"\n"+contact.printPhoneNumber())
					.collect(Collectors.joining("\n"));
		return message;
	}
	
















}