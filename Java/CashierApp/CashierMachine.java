import java.util.Date;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;
public class CashierMachine{
	static final double vat = 0.175;
	private List<List<String>> itemsQuantityPrices = new ArrayList<>();	
	private String name;
	private double discount = 0.0;

	public void setName(String name){
		this.name = name;
	}
	public void setDiscount(double percentage){
		this.discount = percentage/100;
	}
	public double getDiscount(){
		return discount;
	}
	public void addItem(String item, String quantity, String price){
		List<String> eachItem = new ArrayList<>();
		eachItem.add(item);
		eachItem.add(quantity);
		eachItem.add(price);
		itemsQuantityPrices.add(eachItem);
	}
	public List<List<String>> viewAllItems(){
		return itemsQuantityPrices;
	}
	public double getTotal(){
		double amount = 0;
		double subTotal = 0;
		int quantity = 0;
		double price = 0;
		for(int counter = 0; counter < itemsQuantityPrices.size(); counter++){
			for(int count = 0; count < 1; count++){ 
				quantity = Integer.parseInt(itemsQuantityPrices.get(counter).get(1));
				price = Double.parseDouble(itemsQuantityPrices.get(counter).get(2));
				amount = quantity * price;				
			}
			subTotal += amount;			
		}
		return subTotal;
	}

	public String getName(){
		return name;
	}
	
	public void addTotal(){
		String amountStr = null;
		double amount = 0;		
		int quantity = 0;
		double price = 0;
		for(int counter = 0; counter < itemsQuantityPrices.size(); counter++){
			for(int count = 0; count < 1; count++){ 
				quantity = Integer.parseInt(itemsQuantityPrices.get(counter).get(1));
				price = Double.parseDouble(itemsQuantityPrices.get(counter).get(2));
				amount = quantity * price;
				amountStr = String.valueOf(amount);
				itemsQuantityPrices.get(counter).add(amountStr);				
			}						
		}
		for(List<String> itemsQuantityPrice : itemsQuantityPrices){
			for(String each: itemsQuantityPrice){
				System.out.print("\t"+each+"\t");
			}
			System.out.println();
		}		
	}
	public static String printRecieptHeader(String name){
		CashierMachine customer1 = new CashierMachine();
		customer1.setName(name);
		LocalDate todaysDate = LocalDate.now();
		Date now = new Date();
		String message = """
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 09068325098
Date: %s %tT
Cashier: Cashier's name
Customers Name: %s
======================================================================
	Item(s)      QTY            PRICE	       TOTAL(N)
----------------------------------------------------------------------
			""".formatted(todaysDate, now, customer1.getName());	
		return message;
	}
	
	public double getDiscountAmount(){
		double subTotal = getTotal();
		double myDiscount = getDiscount() * subTotal;
		return myDiscount;
	}	
	public double getVatValue(){		
		double subTotal = getTotal();
		return subTotal * vat;
	}
	public double getTotalBill(){
		double subTotal = getTotal();
		double discount = getDiscountAmount();
		double vat = getVatValue();
		double totalBills = subTotal + discount + vat;
		return totalBills;
	}
	public String printRestOfSlip(){
		
		double subTotal = getTotal();
		double discount = getDiscountAmount();
		double vat = getVatValue();
		double totalBill = getTotalBill();
		
		String message = """

----------------------------------------------------------------------

					SubTotal: 	%.2f
					Discount:	%.2f
					Vat @ 17.5%%:	%.2f
======================================================================
					Bill Total:	%.2f
======================================================================
THIS IS NOT AN RECIEPT KINDLY PAY.50


How much did the customer give to you? 
		""".formatted(subTotal, discount, vat , totalBill);
		return message;
	

	}

	public void printFullReciept(String name){
		System.out.println(printRecieptHeader(name));
		addTotal();
		System.out.println(printRestOfSlip());
	
	}



	
}