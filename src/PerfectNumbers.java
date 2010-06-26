import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

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

	
}
