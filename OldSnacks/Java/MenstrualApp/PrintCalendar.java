import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintCalendar{
	
	public static void printCalendar(String input){
	AtomicInteger row = new AtomicInteger();
	LocalDate date = LocalDate.parse(input);
	int index = date.getMonthValue();
	int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};	
      	int []noOfDays = new int[1];
	System.out.printf("%4s%4s%4s%4s%4s%4s%4s%n","M","T","W","TH","F","S","S");	
	noOfDays[0] = months[index];
	IntStream.rangeClosed(1, noOfDays[0])
		 .forEach(day -> {					
		System.out.printf("%4d", day);
		if(row.incrementAndGet() % 7 == 0){
			System.out.println();	
		}});
	System.out.println();
	}




















}