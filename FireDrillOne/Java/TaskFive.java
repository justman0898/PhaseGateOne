public class TaskFive{
	
	public static void main(String[] args){
		int temp = 0;
		for(int counter = 1; counter < 11; counter++){			
			for(int count = 0; count < 5; count++){
				if(counter % 4 == 0){
					temp = counter;			
					System.out.print(temp);
				}
				if(counter % 5 == 0){
					System.out.print(" ");
				}
			}
		}
	}
}
