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

        List<Integer> perfectNumbersInRange() {
            final int ulimit = 10;
            List<Integer> ret = new ArrayList<Integer>();
            for (Integer number : range(ulimit)) {
                if (isPerfect(number)) ret.add(number);
            }
            return ret;
        }

        private List<Integer> range(int ulimit) {
            List<Integer> range = new ArrayList<Integer>();
            for (int j = 1; j <= ulimit; j++) {
                range.add(j);
            }
            return range;
        }

        List<Integer> perfectInParallell() {
        Integer ulimit = 10;
        List<Callable<Integer>> calculations = new ArrayList<Callable<Integer>>();
        for (final Integer number : range(ulimit)) {
            calculations.add(new Callable<Integer>() {
                public Integer call() throws Exception {
                    if (isPerfect(number)) return number;
                    else return 0;
                }
            });
        }
        Set<Integer> perfectNumbers = new TreeSet<Integer>();
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            List<Future<Integer>> results = executor.invokeAll(calculations);
            for (Future<Integer> future : results) {
                try {
                    perfectNumbers.add(future.get());
                } catch (ExecutionException ex) {
                    Logger.getLogger(PerfectNumbersTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(PerfectNumbersTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perfectNumbers;



        }
	
}
