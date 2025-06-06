import java.time.LocalDate;
public class MenstrualCycleApp{
	public static void main(String[] args){

		String date = "2025-08-01";
		//PrintCalendar.printCalendar(date);

		//LocalDate next = CycleTracker.calculateNextPeriodDate(date, 28);
		System.out.println();
		//System.out.println(next);
		System.out.println(CycleTracker.printperiodSpan(date, 28, 5));












	}
}