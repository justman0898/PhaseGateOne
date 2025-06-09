import java.util.Date;
import java.time.LocalDate; 
import java.util.stream.IntStream;
import java.util.stream.Collectors;
public class CreditCard{
	public static boolean validateCardLength(int[] array){
		if(array.length >= 13 && array.length <= 16){
			return true;
		}
		return false;
	}
	public static String checkCardType(int[] array){
		if(array.length >= 13 && array.length <= 16){
			if(array[0] == 4){
				return "Visa Card";
			}
			else if(array[0] == 5){
				return "MasterCard";
			}
			else if(array[0] == 6){
				return "Discover Card";
			}
			else if(array[0] == 3 && array[1] == 7){
				return "American Express Card";
			}else{
				return "Invalid Card";
			}
		}
		return "Invalid Card";
	}	
	public static int getCardLength(int[] array){
		return array.length;
	}
	public static String printCardNumbers(int[] array){
		String message = IntStream.of(array)
         		 		  .mapToObj(num -> String.valueOf(num))
					  .collect(Collectors.joining());
		return message;
	}
	public static boolean checkForNegative(int[] array){
		for(int counter = 0; counter < array.length; counter++){
			if(array[counter] < 0 || array[counter] > 9){
				return true;
			}
		}
		return false;
	}
	public static int firstStep(int[] array){
		int result = 0;
		int sum = 0;
		for(int counter = 0; counter < array.length; counter++){
			if(counter % 2 == 0){
				result = array[counter] * 2;
				if(result > 9){
					result -= 9;
				}
				sum += result;
			}
			 
		}
		return sum;
	}
	public static int addDigitsInOdd(int[] array){
		int total = 0;
		for(int counter = 0; counter < array.length; counter++){
			if(counter % 2 != 0){
				total += array[counter];
			}
		}
		return total;
	}
	public static int getSum(int[] array){
		int evenTotal = firstStep(array);
		int oddTotal =  addDigitsInOdd(array);
		return evenTotal + oddTotal;
	}
	public static boolean checkCard(int[] array){
		int total = getSum(array);
		if(total % 10 == 0){
			return true;
		}
		return false;
	}
	public static String showStatus(boolean status){
		if(status){
			return "Valid";
		}
		return "Invalid";
	} 
	public static String printOutput(int[] array){
		String cardType = checkCardType(array);
		String cardNumber = printCardNumbers(array);
		int cardLength = getCardLength(array);
		String validity = showStatus(checkCard(array));
		LocalDate time = LocalDate.now();
		Date now = new Date();
		String message = """


**********************************************
**Credit Card Type: %s
**Credit Card Number: %s
**Credit Card Length: %d
**Credit Card Validity Status: %s

		Date: %s %tT
**********************************************
		""".formatted(cardType, cardNumber, cardLength, validity, time, now);
		return message;
	}
}