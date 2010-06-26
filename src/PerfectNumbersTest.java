import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

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
