import java.util.*;

public class MbtiTest{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
    			System.out.print("Enter your name: ");
    			String name = scanner.nextLine();

    			List<List<String>> answers = QuestionArray.printQuestions1();
    			QuestionArray.printOutCome(name, answers);
		}catch(IndexOutOfBoundsException e){
			System.out.print("We noticed some answers were missing");
			scanner.nextLine();
		}
		






















	}


}