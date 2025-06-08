import java.util.Arrays;
public class Driver{
	public static void main(String[] args){

		CashierMachine customer1 = new CashierMachine();
		
		customer1.addItem("Parfait", "3", "2400");
		customer1.addItem("Rice", "3", "3500");
		customer1.addItem("Corn", "7", "13500");
		customer1.setDiscount(20.0);
		
		//System.out.println(customer1.printRecieptHeader("Justice Igboneme Obiajulu"));
		//customer1.addTotal();
		
		customer1.printFullReciept("Justice Igboneme Obiajulu");

		//customer1.printFullReciept("Justice Igboneme Obiajulu");
		//System.out.println(customer1.getTotalBill());
		//System.out.println(customer1.getVatValue());







	}



















}