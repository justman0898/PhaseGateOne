import java.util.*;
import java.util.stream.*;
public class PhoneBook{
	private String firstName;
	private String lastName;
	private List<String> phoneNumbers = new ArrayList<>();
	
	public PhoneBook(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public void setFirstName(String name){
		this.firstName = name;
	}
	public void setLastName(String name){
		this.lastName = name;
	}
	public void addPhoneNumbers(List<String> numbers) {
    		phoneNumbers.addAll(numbers);
	}
	public List<String> getPhoneNumbers(){
		return phoneNumbers;	
	}
	public String getPhoneNumber(int index){
		return phoneNumbers.get(index -1);
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String printPhoneNumber(){
		String message = phoneNumbers.stream()					
					.map(String::valueOf)
					.collect(Collectors.joining(" "));
		return message;
	}
	public int getNoOfPhone(){

		return phoneNumbers.size(); 
	}










}