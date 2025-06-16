import java.util.*;
import java.util.stream.*;
public class StudentGradeFunctions{
	//List<Student> students = new ArrayList<>();
	public static String printCard(List<Student> students){		
		String scores = students.stream()
					.map(student -> student.getName() + "\t" + student.printSubjectScores() + "\t" + student.printTotalAndAverage() + "\t" + student.getPosition())
					.collect(Collectors.joining("\n"));
		return scores;

	}
	public static String printSummary1(List<Student> students){
		String data = printCard(students);
		String message = """
===========================================================
STUDENT		SUB1	SUB2	SUB3	TOT	AVE	POS
===========================================================
%s
===========================================================
===========================================================
				""".formatted(data);
		return message;
	}
	public static List<Integer> getTotals(List<Student> students){
		List <Integer> allTotals = students.stream()
						.map(student -> student.getTotalScore())
						.collect(Collectors.toList());
		return allTotals;
	}
	public static List<Double> sortTotals(List<Student> students){
		List<Double> allTotals = collectAverages(students);
		
		for(int counter = 0; counter < allTotals.size(); counter++){
			for(int count = 0; count < allTotals.size() - counter - 1; count++){
				if(allTotals.get(count) < allTotals.get(count + 1)){ 
					double temp = allTotals.get(count);					
					allTotals.set(count, allTotals.get(count + 1));
					allTotals.set(count + 1, temp);
				}			
			}	
		}
		return allTotals;
	}
	
	public static List<Double> collectAverages(List<Student> students){
		List<Double> allAverages = students.stream()
						.map(eachStudent -> eachStudent.getAverage())
						.collect(Collectors.toList());
		return allAverages;
	}
	public static List<Student> sortStudentsInDiscending(List<Student> students){		
		for(int counter = 0; counter < students.size(); counter++){
			for(int count = 0; count < students.size()-counter-1; count++){
				if(students.get(count).getAverage() < students.get(count + 1).getAverage()){
					Student temp = students.get(count);
					students.set(count, students.get(count + 1));
					students.set(count + 1 ,temp);			
				}
			}
		}
		return students;
	}
	public static List<Student> setPositions(List<Student> students){
		List<Student> studentsInDescending = sortStudentsInDiscending(students);
		int currentPosition = 1;
		for(int counter = 0; counter < studentsInDescending.size(); counter++){
			if(counter > 0 && studentsInDescending.get(counter).getAverage() == studentsInDescending.get(counter - 1).getAverage()){
				studentsInDescending.get(counter).setPosition(studentsInDescending.get(counter - 1).getPosition());
			} else {
				studentsInDescending.get(counter).setPosition(currentPosition);
			}
			currentPosition++;
		}
		return studentsInDescending;
	}

	public static String getHightestInSub1(List<Student> students, int subject){
		int subjects = students.get(0).getNumberOfSubjects();
		List<Integer> subHighests = IntStream.rangeClosed(1, subjects)
				.mapToObj(subjectIndex -> students.stream()
					.map(student -> student.getSubject(subjectIndex))				
					.mapToInt(score -> Integer.valueOf(score)) 
					.max()
					.orElse(0))
				.collect(Collectors.toList());
		
		String output = students.stream()
					.map(student -> { 
						if(student.getSubject(subject) == subHighests.get(subject - 1)){
							return student.getName() + " scoring " + student.getSubject(subject);
						} else {
            						return "";
					        }})
					.filter(space -> !space.isBlank())
					.collect(Collectors.joining("\n"));
		
		return output;
	}
	public static String getLowestInSub1(List<Student> students, int subject){
		int numberOfSubjects = students.get(0).getNumberOfSubjects();
		List<Integer> highestsInAllSubs = IntStream.rangeClosed(1, numberOfSubjects)
							.mapToObj(index -> students.stream()
								.map(student -> student.getSubject(index))
								.mapToInt(score -> Integer.valueOf(score))
								.min().orElse(0))
							.collect(Collectors.toList());
		String output = students.stream()
					.map(student -> {
						if(student.getSubject(subject) == highestsInAllSubs.get(subject - 1)){
							return student.getName() + " scoring " + student.getSubject(subject);
						} else {
							return "";
						}						
					})
					.filter(space -> !space.isBlank())
					.collect(Collectors.joining("\n"));
		return output;
	}
	public static int getTotalInSub(List<Student> students, int subject){
		int sumTotalOfSub = students.stream()
					.map(student -> student.getSubject(subject))
					.mapToInt(scores -> Integer.valueOf(scores))
					.sum();
		return sumTotalOfSub;
	} 
	public static double getAverageInSub(List<Student> students, int subject){
		double averageOfSub = students.stream()
					.map(student -> student.getSubject(subject))
					.mapToInt(scores -> Integer.valueOf(scores))
					.average().orElse(0.0);
		return averageOfSub;
	}
	public static long getNoOfPasses(List<Student> students, int subject){
		long noOfPasses = students.stream()
					.filter(student -> student.getSubject(subject) >= 50)
					.map(student -> student.getSubject(subject))						
					.mapToInt(scores -> Integer.valueOf(scores))
					.count();
		return noOfPasses;
	}
	public static long getNoOfFailures(List<Student> students, int subject){
		long noOfFailures = students.stream()
					.filter(student -> student.getSubject(subject) <= 50)
					.map(student -> student.getSubject(subject))
					.mapToInt(scores -> Integer.valueOf(scores))
					.count();
		return noOfFailures;
	}
	public static String printSubSummary(List<Student> students, int subject){
		String message = """
=================================================
Subject %d
=================================================
Highest scoring student is: %s
Lowest scoring studeent is: %s
Total score is: %d
Average score is: %.2f
Number of passes: %d
Number of Fails: %d
================================================
		""".formatted(subject, StudentGradeFunctions.getHightestInSub1(students, subject),StudentGradeFunctions.getLowestInSub1(students, subject),StudentGradeFunctions.getTotalInSub(students, subject),StudentGradeFunctions.getAverageInSub(students, subject), StudentGradeFunctions.getNoOfPasses(students, subject), StudentGradeFunctions.getNoOfFailures(students, subject));									
		return message;
	}
	public static List<Long> easiestSubject(List<Student> students){
		List<Long> passesInAllSubs = new ArrayList<>();
		for(int counter = 1; counter <= students.get(0).getNumberOfSubjects(); counter++){
			passesInAllSubs.add(StudentGradeFunctions.getNoOfPasses(students, counter));			
		}
		return passesInAllSubs;
	}
	public static List<Long> hardestSubject(List<Student> students){
		List<Long> failuresInAllSubs = new ArrayList<>();
		for(int counter = 1; counter <= students.get(0).getNumberOfSubjects(); counter++){
			failuresInAllSubs.add(StudentGradeFunctions.getNoOfFailures(students, counter));			
		}
		return failuresInAllSubs;
	}
	/*
	for(int counter = 1; counter <= failuresInAllSubs.size(); counter++){
		max is the highest fails in the no of fails list
		if(failuresInAllSubs.get(counter) == max){
			System.out.println("The hardest subject is Subject " +counter+ "with" + max + "failures");
		}

	}
	*/
	public static String printHardest(List<Student> students){
		List<Long> failuresInAllSubs = hardestSubject(students); 
		long max = failuresInAllSubs.stream()
					.mapToLong(failures -> Long.valueOf(failures))
					.max().orElse(0);
		
		Optional<Integer> firstHardest = IntStream.range(0, failuresInAllSubs.size())		
						.filter(subject -> max > 0 && failuresInAllSubs.get(subject) == max)
						.boxed()
						.findFirst();
		String message = firstHardest
										
					.map(subject -> "The hardest subject is Subject " +(subject + 1)+ " with " +max+ " failures")
					.orElse("No Failures recorded");
					
		return message;
	}
	public static String printEasiest(List<Student> students){
		List <Long> passesInAllSubs = easiestSubject(students);	
		long max = passesInAllSubs.stream()
					.mapToLong(passes -> Long.valueOf(passes))
					.max().orElse(0);
		
		Optional<Integer> firstEasiest = IntStream.range(0, passesInAllSubs.size())
							.filter(subject -> max > 0 && passesInAllSubs.get(subject) == max)
							.boxed()
							.findFirst();
		String message = firstEasiest					
					.map(subject -> "The easiest subject is Subject " +(subject+1)+ " with " +max+ " passes")
					.orElse("No success recorded");
		return message;
	}
	
	public static String getOverallHighestScore(List<Student> students){
		int subjects = students.get(0).getNumberOfSubjects();
		//
		List<Long> overallHighestScores = IntStream.rangeClosed(1, subjects)
 							.mapToObj(subject -> students.stream()
								.map(student -> student.getSubject(subject))
								.mapToLong(scores -> Long.valueOf(scores))
								.max().orElse(0))
							.collect(Collectors.toList());
		long maxFromAllSubs = overallHighestScores.stream()
							.mapToLong(scores -> Long.valueOf(scores))
							.max().orElse(0);
		String message = IntStream.rangeClosed(1, subjects)
					.boxed()
					.flatMap(subject -> students.stream()
						.filter(student -> student.getSubject(subject) == maxFromAllSubs)
						.map(student -> "Overall Highest Score is scored by "+student.getName()+ " in subject " +subject+" scoring "+maxFromAllSubs))
					.collect(Collectors.joining("\n"));
		return message;
	}
	public static String getOverallLowestScore(List<Student> students){
		int subjects = students.get(0).getNumberOfSubjects();
		List<Long> overallLowestScores = IntStream.rangeClosed(1, subjects)
 							.mapToObj(subject -> students.stream()
								.map(student -> student.getSubject(subject))
								.mapToLong(scores -> Long.valueOf(scores))
								.min().orElse(0))
							.collect(Collectors.toList());
		long minFromAllSubs = overallLowestScores.stream()
							.mapToLong(scores -> Long.valueOf(scores))
							.min().orElse(0);
		String message = IntStream.rangeClosed(1, subjects)
					.boxed()
					.flatMap(subject -> students.stream()
						.filter(student -> student.getSubject(subject)== minFromAllSubs)
						.map(student -> "Overall Lowest score is scored by "+student.getName()+" in subject "+subject+" scoring "+minFromAllSubs))
					.collect(Collectors.joining("\n"));
		return message;
	}
	public static String printBestGradStudent(List<Student> students){
		long highestTotal = students.stream()
					.map(student -> student.getTotalScore())
					.mapToInt(score -> Integer.valueOf(score))
					.max().orElse(0);
		
		String message = students.stream()
					.filter(student -> student.getTotalScore() == highestTotal)
					.map(student -> "Best Graduating Student is: "+student.getName()+" scoring "+highestTotal)
					.collect(Collectors.joining("\n"));
		return message;
	}			
	public static String printWorstGradStudent(List<Student> students){
		long lowestTotal = students.stream()
					.map(student -> student.getTotalScore())
					.mapToInt(score -> Integer.valueOf(score))
					.min().orElse(0);
		String message = students.stream()
					.filter(student -> student.getTotalScore() == lowestTotal)
					.map(student -> "Worst Graduating Student is: "+student.getName()+" scoring "+lowestTotal)
					.collect(Collectors.joining("\n"));
		return message;
	}
	public static long getClassTotal(List<Student> students){
		long classTotal = students.stream()
					.map(student -> student.getTotalScore())
					.mapToInt(Integer::valueOf)
					.sum();
		return classTotal;
	}
	public static double getClassAverage(List<Student> students){
		double classAverage = students.stream()
					.map(student -> student.getTotalScore())
					.mapToDouble(Double::valueOf)
					.average().orElse(0.0);
		return classAverage;
	}
	public static String printSummary(List<Student> students){
		String message = """

%s
%s
%s
%s
==================================================

Class Summary
==================================================
%s
==================================================

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
%s
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

==================================================
Class total score is: %d
Class Average score is: %.1f
==================================================	
	""".formatted(printHardest(students),printEasiest(students),getOverallHighestScore(students),getOverallLowestScore(students),printBestGradStudent(students),printWorstGradStudent(students),getClassTotal(students),getClassAverage(students));
	return message;


	}

}