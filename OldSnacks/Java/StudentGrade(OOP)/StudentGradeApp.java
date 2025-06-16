import java.util.*;
public class StudentGradeApp{
	public static void main(String[] args){
		List<Student> students = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int noOfStudents = 0;
		int noOfSubject = 0;
		List<Integer> scoreList = new ArrayList<>();
		while(true){	
			try{
				System.out.println("How many students do you have?");
				noOfStudents = scanner.nextInt();
				System.out.println("How many subjects?");
				noOfSubject = scanner.nextInt();
				System.out.println("Saving >>>>>>>>>>>>>>>>>>>>");
				System.out.println("Saved Successfully!");
				break;

			}catch(InputMismatchException exception){
					System.out.println("Enter correct data!");
					scanner.nextLine();
			}
		}

		for(int counter = 0; counter < noOfStudents; counter++){
			students.add(new Student());
			students.get(counter).setName("Student "+(counter+1));
		}
				
		for(int count = 0; count < students.size(); count++){ 	
			for(int counter = 0; counter < noOfSubject; counter++) {
				while(true){
					try{
						System.out.println();
						System.out.println("Entering score for student "+(count+1));
    						System.out.println("Enter score for subject "+(counter+1));
    						int score = scanner.nextInt();    													students.get(count).setSubjectsScores(score);
						System.out.println("Saving >>>>>>>>>>>>>>>>>>>>");
						System.out.println("Saved Successfully!");
    						break;
					}catch(InputMismatchException | NumberFormatException exception){
						System.out.println("We detected an invalid input!!!");
						scanner.nextLine();
					}
				}
			}
		}
		StudentGradeFunctions.setPositions(students);
		System.out.println(StudentGradeFunctions.printSummary1(students));	
		System.out.println();
		System.out.println();
		for(int counter = 1; counter <= noOfSubject; counter++){
			System.out.println(StudentGradeFunctions.printSubSummary(students, counter));		
			System.out.println();
			System.out.println();
		}
		System.out.println("RUNDOWN !!!!");
		System.out.println("________________________________________________");		
		System.out.println();
		System.out.println(StudentGradeFunctions.printSummary(students));
	}


}