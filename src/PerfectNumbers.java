import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerfectNumbers {

	List<Integer> factorsOf(int number) {
		if (number == 1)
			return asList(number);
		else {
			return findFactorsForNumbersCreaterThanOne(number);
		}
	}

	private List<Integer> findFactorsForNumbersCreaterThanOne(int number) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int j = 1; j <= number / 2; j++) {
			if ((number % j) == 0) {
				factors.add(j);
			}
		}
		return factors;
	}

	private int sum(List<Integer> factors) {
		int sum = 0;
		for (Integer factor : factors) {
			sum += factor;
		}
		return sum;
	}

	boolean isPerfect(int number) {
		List<Integer> factors = factorsOf(number);
		return number == sum(factors);
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
            perfectNumbers.remove(0);
            return (List<Integer>) perfectNumbers;
        }
}
