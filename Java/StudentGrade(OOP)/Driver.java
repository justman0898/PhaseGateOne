import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Driver{
	public static void main(String[] args){ 
		List<Student> students = new ArrayList<>(); 
		students.add(new Student());
    		students.add(new Student());
		students.add(new Student());
    		students.add(new Student());
    		
		students.get(0).setName("Student 1");
		students.get(1).setName("Student 2");
		students.get(2).setName("Student 3");
		students.get(3).setName("Student 4");
		students.get(0).setSubjectsScores(67, 21, 49);
		students.get(1).setSubjectsScores(98, 62, 56);
		students.get(2).setSubjectsScores(93, 34, 27);
		students.get(3).setSubjectsScores(97, 83, 66);
		
		//System.out.println(StudentGradeFunctions.getHightestInSub1(students, 2));
		//System.out.println(StudentGradeFunctions.printSummary1(students));
		System.out.println(students.get(0).getSubject(1));
		//System.out.println(StudentGradeFunctions.sortTotals(students));
		System.out.println(StudentGradeFunctions.setPositions(students));
		System.out.println(StudentGradeFunctions.printSummary1(students));
		System.out.println(StudentGradeFunctions.getHightestInSub1(students, 1));
		
		//sortedTotalsIndex









	}

}