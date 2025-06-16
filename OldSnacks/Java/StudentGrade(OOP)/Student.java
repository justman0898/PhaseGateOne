import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
public class Student{
	private String name;
	private List<Integer> subjectScores = new ArrayList<>();
	private List<Double> totalAndAverage = new ArrayList<>();
	private int position;
	 
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setPosition(int position){
		this.position = position;
	}
	public int getPosition(){
		return position;
	}
	public void setSubjectsScores(int score){
		if(score < 0 || score >= 100){
			throw new NumberFormatException("Invalid Score, score cannot be negative or over 100");
		}
        	subjectScores.add(score);		
	}
	public List<Integer> getSubScores(){
		return subjectScores;
	}
	public String printSubjectScores(){
		List<Integer> subjectScores = getSubScores();
		String subjectScore = subjectScores.stream()
							.map(each -> String.valueOf(each))
							.collect(Collectors.joining("\t"));
		return subjectScore;
	}
	
	public int getTotalScore(){
		List<Integer> subjectScore = getSubScores();
		int total = subjectScore.stream()
					.mapToInt(each -> Integer.valueOf(each))
					.sum();
		
		return total;
	}
	public double getAverage(){
		List<Integer> subjectScore = getSubScores();
		int totalScore = getTotalScore();
		double average = (double)totalScore / subjectScore.size();
		double roundedAverage = Math.round(average * 100.0)/ 100.0;
		return roundedAverage;
	}
	public String printTotalAndAverage(){
		List<Double> totalAndAverage = getTotalAndAverage();
		String totalAndAverag = totalAndAverage.stream()
							.map(each -> String.valueOf(each))
							.collect(Collectors.joining("  "));
		return totalAndAverag;
	}
	public List<Double> getTotalAndAverage(){
		double total = (double)getTotalScore();
		double roundedTotal = Math.round(total);
		double average = getAverage();
		totalAndAverage.add(roundedTotal);
		totalAndAverage.add(average);
		return totalAndAverage;
	}
	public int getSubject(int subject){
		return subjectScores.get(subject - 1);
	}
	public int getNumberOfSubjects(){
		return subjectScores.size();
	}

	 








}