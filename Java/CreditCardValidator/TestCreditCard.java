import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestCreditCard{
	@Test
	public void testValidateCardLength(){
		int[] x ={1,2,3,4,5,6,7,8,9,2,3,9,8,1};
		assertEquals(true, CreditCard.validateCardLength(x));
	}
	@Test
	public void testGetCardType(){
		int[] x ={3,7,3,4,5,6,7,8,9,2,3,9,8,1};
		assertEquals("American Express Card", CreditCard.checkCardType(x));
	}
	@Test
	public void testGetCardLength(){
		int[] x ={1,2,3,4,5,6,7,8,9,2,3,9,8,1};
		assertEquals(14, CreditCard.getCardLength(x));
	}
	@Test
	public void testWithNegative(){
		int[] x ={1,2,3,4,5,-6,7,8,9,2,3,9,8,1};
		assertEquals(true, CreditCard.checkForNegative(x));
	}
	@Test
	public void testfirstStep(){
		int[] x ={4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
		assertEquals(37, CreditCard.firstStep(x));
	}
	@Test
	public void testaddDigitsInOdd(){
		int[] x ={4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
		assertEquals(38, CreditCard.addDigitsInOdd(x));
	}
	@Test
	public void testgetSum(){
		int[] x ={4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};
		assertEquals(75, CreditCard.getSum(x));
	}
	@Test
	public void testcheckCard(){
		int[] x ={4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
		assertEquals(true, CreditCard.checkCard(x));
	}
	@Test
	public void testshowStatus(){
		int[] x ={4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
		boolean actual = CreditCard.checkCard(x);
		assertEquals("Valid", CreditCard.showStatus(actual));
	}
	@Test
	public void testconvertStringToArray(){
		String x = "4388576018410707";		
		int[] expected ={4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
		assertArrayEquals(expected, StringConversion.convertStringToArray(x));
	}















}