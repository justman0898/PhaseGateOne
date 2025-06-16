import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
public class QuestionArray{
	static List<String> extrovertedVsIntroverted = new ArrayList<>();	 
	static List<String> sensingVsIntuitive = new ArrayList<>();	
	static List<String> thinkingVsFeeling = new ArrayList<>();	
	static List<String> judgingVsPerceptive = new ArrayList<>();
	
	public static List<String> addextrovertedVsIntrovertedQuestions(){
		extrovertedVsIntroverted.add("A.expend energy, enjoy groups");
		extrovertedVsIntroverted.add("B.conserve energy, enjoy one-on-one");		
		extrovertedVsIntroverted.add("A.more outgoing, think out loud");
		extrovertedVsIntroverted.add("B.more reserved, think to yourself");
		extrovertedVsIntroverted.add("A.seek many tasks, public activities, interaction with others");
		extrovertedVsIntroverted.add("B.seek private, solitary activities with quiet to concentrate");
		extrovertedVsIntroverted.add("A.external, communicative, express yourself");
		extrovertedVsIntroverted.add("B.internal, reticent, keep to yourself");
		extrovertedVsIntroverted.add("A.active, intitate");
		extrovertedVsIntroverted.add("B.reflective, deliberate");
		return extrovertedVsIntroverted;
	}
	public static List<String> addsensingVsIntuitive(){
		sensingVsIntuitive.add("A.Interpret, literally");
		sensingVsIntuitive.add("B.Look for meaning and possibilities");
		sensingVsIntuitive.add("A.practical, realistic, experimental");
		sensingVsIntuitive.add("B.imaginative, innovative, theoretical");
		sensingVsIntuitive.add("A.standard, usual, conventional");
		sensingVsIntuitive.add("B.different, novel, unique");
		sensingVsIntuitive.add("A.focus on here and now");
		sensingVsIntuitive.add("B.look to the future , global perpective, big picture");
		sensingVsIntuitive.add("A.facts, things, what is");
		sensingVsIntuitive.add("B.ideas, dreams, what could be, philosphical");
		return sensingVsIntuitive;
	}
	public static List<String> addThinkingVsFeeling(){
		thinkingVsFeeling.add("A.Logical, thinking, questioniong");
		thinkingVsFeeling.add("B.empathetic, feeling, accomodating");
		thinkingVsFeeling.add("A.candid, straightforward, frank");
		thinkingVsFeeling.add("B.tactful, kind, encouraging");
		thinkingVsFeeling.add("A.firm, tend to criticize, hold the line");
		thinkingVsFeeling.add("B.gentle, tend to appreciate, conciliate");
		thinkingVsFeeling.add("A.tough minded, just");
		thinkingVsFeeling.add("B.tender-heated, merciful");
		thinkingVsFeeling.add("A.matter of fact, issue-oriented");
		thinkingVsFeeling.add("B.sensitive, people-oriented, compassionate");
		return thinkingVsFeeling;
	}
	public static List<String> addJudgingVsPerceptive(){
		judgingVsPerceptive.add("A.organized, orderly");
		judgingVsPerceptive.add("B.flexible, adaptable");
		judgingVsPerceptive.add("A.plan, schedule");
		judgingVsPerceptive.add("B.unplanned, spontaneous");
		judgingVsPerceptive.add("A.regulated, structured");
		judgingVsPerceptive.add("B.easy-going, live and let live");
		judgingVsPerceptive.add("A.preparation, plan ahead");
		judgingVsPerceptive.add("B.go with the flow, adapt as you go");
		judgingVsPerceptive.add("A.control, govern");
		judgingVsPerceptive.add("B.latitude, freedom");
		return judgingVsPerceptive;
	} 
	public static List<List<String>> printQuestions1(){
		Scanner scanner = new Scanner(System.in);
		List<String> introvertVsExtroverts1 = addextrovertedVsIntrovertedQuestions();
		List<String> sensingVsIntuitive1 = addsensingVsIntuitive();
		List<String> thinkingVsFeeling1 = addThinkingVsFeeling();
		List<String> judgingVsPerceptive1 = addJudgingVsPerceptive();
		List<List<String>> allQuestions = Arrays.asList(introvertVsExtroverts1,sensingVsIntuitive1,thinkingVsFeeling1,judgingVsPerceptive1);
		List<List<String>> answers = new ArrayList<>();
		
        	for (int i = 0; i < allQuestions.size(); i++) {
            		answers.add(new ArrayList<>());
       		}		
		int max = allQuestions.stream()
			.mapToInt(List::size)
			.max()
			.getAsInt();
		for(int round = 0; round < max; round+=2){
			for(int count = 0; count<allQuestions.size();count++){		
				List<String> currentList = allQuestions.get(count);
				System.out.print(currentList.get(round));
				System.out.println("\t" + currentList.get(round + 1));
				System.out.println("Your answer: ");
				String answer = scanner.nextLine().toLowerCase();
				answers.get(count).add(answer);
			}
		}
		return answers;
	}
	public static List<Integer> getnoOfAsInEachRow(){
		List<List<String>> answers = printQuestions1();
		List<Integer> noOfAsInEachRow = answers.stream()
					.map(innerList -> (int) innerList.stream()					
					.filter(letter -> letter.startsWith("a"))
					.count())
					.collect(Collectors.toList());
		return noOfAsInEachRow;
	}	
	public static List<Integer> getnoOfBsInEachRow(){
		List<List<String>> answers = printQuestions1();
		List<Integer> noOfBsInEachRow = answers.stream()
						.map(innerList -> (int) innerList.stream()
						.filter(letter -> letter.startsWith("b"))
						.count())
						.collect(Collectors.toList());
		return noOfBsInEachRow;
	}

}

