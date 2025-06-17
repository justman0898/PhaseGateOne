public class TaskNine{	
	public static void main(String[] args){		
		int counter = 0;		
		int temp = 1;
		long sum = 0;
		while(true){
			temp = temp * 4;
			sum = sum + temp;
			
			counter++;
		
			if(counter == 5) break; 
		}				 
		temp = 1;
		counter = 0;						
		while(true){
			temp = temp * 8;
			sum = sum + temp;			
			counter++;		
			if(counter == 5) break; 
		}		
		System.out.print((sum*sum)+" ");
		
	}
}
