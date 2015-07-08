package lambdas;

import java.util.stream.IntStream;

public class FizzBuzz {

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 100).mapToObj(FizzBuzz::valueOf).forEach(System.out::println);
	}

	public static String valueOf(int i) {
		if (i % 15 == 0)
			return "fizz-buzz";
		if (i % 3 == 0)
			return "fizz";
		if (i % 5 == 0)
			return "buzz";
		return Integer.toString(i);
	}
}
