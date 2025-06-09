public class StringConversion{
	public static int[] convertStringToArray(String strNumbers){
		int number = 0;
		int[] numbers = new int[strNumbers.length()];
		for(int counter = 0; counter < strNumbers.length(); counter++){
			String ch_number = String.valueOf(strNumbers.charAt(counter));
			number = Integer.parseInt(ch_number);
			numbers[counter] = number;
		}
		return numbers;
	}





















}