
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
public class TestStudentGrade{
	List<Student> students = new ArrayList<>();
	
	@BeforeEach
	public void setUp(){
		students.add(new Student());
    		students.add(new Student());
    		students.add(new Student());
		students.get(0).setName("Student 1");
		students.get(1).setName("Student 2");
		students.get(0).setSubjectsScores(67);
		students.get(0).setSubjectsScores(21);
		students.get(0).setSubjectsScores(49);

	}
	@Test
	public void testSetName(){		
		assertEquals("Student 1", students.get(0).getName());
	}
	@Test
	public void testGetName(){		
		assertEquals("Student 2", students.get(1).getName());
	}
	@Test
	public void testGetSubjectScores(){		
		List<Integer> expected = List.of(67, 21, 49);		
		assertEquals(expected, students.get(0).getSubScores());
	}
	@Test
	public void testGetTotalScore(){	
		assertEquals(137, students.get(0).getTotalScore());
	}
	@Test
	public void testGet(){	
		//students.get(0).averAverage()
		assertEquals(45.67, students.get(0).getAverage());
	}
	@Test
	public void testGetTotalAndAverage(){	
		List<Double> expected = List.of(137.0, 45.67);
		assertEquals(expected, students.get(0).getTotalAndAverage());
	}

		









}