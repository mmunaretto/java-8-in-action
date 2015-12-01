package lambdas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringCalulcatorTest {

	@Test
	public void add() {
		assertEquals(0, StringCalculator.add(""));
		assertEquals(1, StringCalculator.add("1"));
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void addUnknownAmountOfNumbers() {
		assertEquals(55, StringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test
	public void newLinesBetweenNumbers() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test
	public void supportDifferentDelimiters() {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}

	@Test
	public void negativesNotAllowed() {
		try {
			StringCalculator.add("1,-1,2,-2");
			fail("NegativeNotAllowedException not thrown");
		} catch (NegativeNotAllowedException ex) {
			assertEquals("-1,-2", ex.getMessage());
		}
	}

	@Test
	public void numberBiggerThen1000Ignored() {
		assertEquals(2, StringCalculator.add("2,1001"));
	}

	@Test
	public void supportAnyLengthDelimiters() {
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void allowMultipleDelimiters() {
		assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void allowMultipleDelimitersWithLengthLongerThanOneChar() {
		assertEquals(6, StringCalculator.add("//[**][%%%]\n1**2%%%3"));
	}
}
