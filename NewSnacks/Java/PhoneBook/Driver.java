import java.util.*;
import java.util.stream.*;
public class Driver{
	public static void main(String[] args){
		List<PhoneBook> contacts = new ArrayList<>();
		contacts.add(new PhoneBook("Justice"));
		contacts.add(new PhoneBook("Justice"));
		//contacts.get(0).setFirstName("Justice");
		//contacts.get(1).setFirstName("Igboneme");
		contacts.get(0).setLastName("Justice");
		contacts.get(1).setLastName("Igboneme");
		contacts.get(0).addPhoneNumber("09068325094");
		contacts.get(0).addPhoneNumber("09068325094");
		contacts.get(1).addPhoneNumber("09068325094");
		contacts.get(1).addPhoneNumber("09068325094");
		System.out.println(PhoneBookFunctions.searchContactLastName(contacts, "Justice"));

















	}


}