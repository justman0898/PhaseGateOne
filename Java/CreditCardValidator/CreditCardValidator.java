import java.util.Scanner;
import java.util.Arrays;
public class CreditCardValidator{
	public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("Hello, Kindly Enter Card details to verify");
			String cardNumbers = scanner.nextLine();
			//Integer.parseInt(cardNumbers);
			int[] numbers = StringConversion.convertStringToArray(cardNumbers);
			System.out.println(CreditCard.printOutput(numbers));
		}catch(NumberFormatException exception){
			System.out.println("We detected that you enter wrong data type. Try again....");
		}

















	}








}