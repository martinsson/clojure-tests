import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;


public class PerfectNumbersTest {

	private final PerfectNumbers perfectNumbers = new PerfectNumbers();
	@Test
	public void factorsOfOneIsOne() throws Exception {
		assertThat(factorsOf(1), equalTo(asList(1)));
	}

	@Test 
	public void factorsOfThreeIsOne() throws Exception {
		assertThat(factorsOf(3), equalTo(asList(1)));
	}
	
	@Test 
	public void factorsOfTenAreOneTwoAndFive() throws Exception {
		assertThat(factorsOf(10), equalTo(asList(1, 2, 5)));
	}
	
	List<Integer> factorsOf(int number) {
		return perfectNumbers.factorsOf(number);
	}
	
	@Test
	public void oneIsAPerfectNumber() throws Exception {
		int number = 1;
		assertThat(isPerfect(number), is(true));
	}

	@Test
	public void sixIsAPerfectNumber() throws Exception {
		int number = 6;
		assertThat(isPerfect(number), is(true));
	}

	@Test
	public void nineIsNOTAPerfectNumber() throws Exception {
		int number = 9;
		assertThat(isPerfect(number), is(false));
	}

	private boolean isPerfect(int number) {
		return perfectNumbers.isPerfect(number);
	}
	
}
