import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;
public class MenstrualCycleApp{
	
	public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
		String lastPeriodDate = null;
		int averageCycleLength = 0;
		int periodLength = 0;
		boolean inMainMenu = true;
		int userInput = 0;
		while(inMainMenu){
			System.out.println("""
=== Welcome to Semicolon Period Tracker ===
1. SIGN UP : Lets get some basic details about you.

2. VIEW PERIOD INFO: View your next period date,
fertile days etc.
How to Measure It:
Mark the first day of your period (Day 1).
Count up to the day before your next period starts.
That number is your cycle length.

0. EXIT......
		""");
			boolean validInput = true;
			while(validInput){
				try{
				System.out.print("Choose an option: ");			
				userInput = scanner.nextInt();
				scanner.nextLine();
				if(userInput == 1 || userInput == 2 || userInput == 0){
					validInput = false;
				}
				}catch(InputMismatchException exception){
					System.out.println("Wrong Input");
					scanner.nextLine();
				}
			}			
			switch(userInput){
				case 1 -> {
					boolean inSignUp = true;
					boolean isValid = false;
					while(inSignUp){					
						while(!isValid){
							try{
								System.out.print("Enter the Start Date of your Last period (YYYY-MM-DD): ");	
								lastPeriodDate = scanner.nextLine();					
								System.out.println();					
								System.out.print("Enter your average cycle length: ");
								averageCycleLength = scanner.nextInt();					
								System.out.println();					
								System.out.print("Enter your average period length: ");		
								periodLength = scanner.nextInt();
								isValid = true;
								System.out.println("Thank you for Signing up!\n\n");
							} catch(InputMismatchException exception){
								System.out.println("Wrong Input");
								scanner.nextLine();
							}
						}		
								
						
						System.out.println();
						System.out.println("0. BACK");
						try{
							int back = scanner.nextInt();
							if(back == 0){
								break;
							}else{
								System.out.println("Enter a valid input!");
							}
						}catch(InputMismatchException exception){
							System.out.println("Wrong Input");
							scanner.nextLine();
						}

					}
				}
				case 2 -> {
					boolean inView = true;
					while(inView){
						try{						
						PrintCalendar.printCalendar(lastPeriodDate);
						System.out.println();
						LocalDate next = CycleTracker.calculateNextPeriodDate(lastPeriodDate, averageCycleLength);
						LocalDate ovulation = CycleTracker.calculateOvulationWindow(lastPeriodDate, averageCycleLength);
						String message = """
Your next period is expected on: %s
Estimated ovulation day: %s
""".formatted(next, ovulation);
						System.out.println(message);						
						System.out.println(CycleTracker.calculateFertileWindow(lastPeriodDate, averageCycleLength));
						System.out.println(CycleTracker.printperiodSpan(lastPeriodDate, averageCycleLength,periodLength));
						}catch(DateTimeParseException | NullPointerException exception){
							System.out.println("No profile Created. Press Any Key");
							scanner.nextLine();
						}
						boolean isValid = true;
						while(isValid){
							System.out.println("0. BACK");
							try{
							
								int back = scanner.nextInt();												
								if(back == 0){
									isValid = false;
									inView = false;

								}else{
									System.out.println("Enter a valid input!");									
								}														
							}catch(InputMismatchException exception){
								System.out.println("Wrong Input");
								scanner.nextLine();
							}
						}
						
						

					}
				}//
				case 0 -> {
					inMainMenu = false;


 
				}	

			}
		
		}
		String date = "2025-05-28";












		
		//PrintCalendar.printCalendar(date);
		/*
		LocalDate next = CycleTracker.calculateNextPeriodDate(date, 28);
		System.out.println();
		System.out.println(next);
		System.out.println(CycleTracker.getCountDown(date, 28));

		*/










	}
}