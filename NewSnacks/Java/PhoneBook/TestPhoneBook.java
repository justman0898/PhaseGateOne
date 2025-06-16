import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;

public class TestPhoneBook{
	List<PhoneBook> contacts = new ArrayList<>();
	@BeforeEach
	public void setUp(){
		contacts.add(new PhoneBook());
    		contacts.add(new PhoneBook());
	}
	@Test
	public void testAddPhoneNumber(){
		contacts.get(0).addPhoneNumber("09068325094");
		List<Character> expected = List.of('0','9','0','6','8','3','2','5','0','9','4');
		assertEquals(expected, contacts.get(0).getPhoneNumber(1));
	}
	



















}