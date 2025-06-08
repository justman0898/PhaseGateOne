import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class CycleTracker{

	public static LocalDate calculateNextPeriodDate(String lastPeriodDate, int averageCycleLength){
		LocalDate lastPeriod = LocalDate.parse(lastPeriodDate);
		LocalDate nextPeriod = lastPeriod.plusDays(averageCycleLength);		
		
		return nextPeriod;
	}
	public static LocalDate calculateOvulationWindow(String lastPeriodDate, int averageCycleLength){
		LocalDate nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, averageCycleLength);
		LocalDate ovulation = nextPeriodDate.minusDays(14);
		
		return ovulation;
	}	
	public static String calculateFertileWindow(String lastPeriodDate, int averageCycleLength){
		LocalDate ovulationValue = calculateOvulationWindow(lastPeriodDate, averageCycleLength);
		LocalDate fertileWindowStart = ovulationValue.minusDays(5);
		LocalDate fertileWindowEnd = fertileWindowStart.plusDays(6);
		String message = """
Your fertile Window starts on %s
It can typically go up to 6 days
Ends at: %s  """.formatted(fertileWindowStart, fertileWindowEnd);
		return message;
	}
	public static String printperiodSpan(String lastPeriodDate, int averageCycleLength, int averagePeriodLength){
		LocalDate startDate = calculateNextPeriodDate(lastPeriodDate, averageCycleLength);
		LocalDate endDate = startDate.plusDays(averagePeriodLength);
		String message = """
Your next period starts on %s and
Ends on %s""".formatted(startDate,endDate);

		return message;
	}

	public static long getCountDown(String lastPeriodDate, int averageCycleLength){
		LocalDate nextPeriod = calculateNextPeriodDate(lastPeriodDate ,averageCycleLength);
		long count = ChronoUnit.DAYS.between(LocalDate.now(), nextPeriod);
		return count;
	}





}