import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
					.collect(Collectors.joining("\n"));
		
		return output;
	}










}