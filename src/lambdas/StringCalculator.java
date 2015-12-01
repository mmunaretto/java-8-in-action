package lambdas;

import static java.lang.Integer.parseInt;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

	public static int add(String numbers) throws NegativeNotAllowedException {
		if (numbers.isEmpty())
			return 0;

		Matcher matcher = matcher(numbers);
		String delimiter = delimiter(matcher, ",|\n");
		String[] addendum = numbers(matcher, numbers).split(delimiter);
		checkForNegatives(addendum);
		return sum(addendum);
	}

	private static String numbers(Matcher matcher, String numbers) {
		if (matcher.matches()) {
			return matcher.group(4);
		}
		return numbers;
	}

	private static String delimiter(Matcher matcher, String defaultDelimiter) {
		if (matcher.matches()) {
			return Stream.of(matcher.group(2).split(Pattern.quote("][")))
					.map(Pattern::quote)
					.collect(Collectors.joining("|")) + "|\n";
		}
		return defaultDelimiter;
	}

	private static int sum(String[] addendum) {
		return Stream.of(addendum)
				.mapToInt(s -> parseInt(s))
				.filter(i -> i >= 0 && i < 1000)
				.sum();
	}

	private static void checkForNegatives(String[] addendum) {
		List<Integer> negatives = Stream.of(addendum)
				.mapToInt(s -> parseInt(s))
				.filter(i -> i < 0)
				.boxed()
				.collect(Collectors.toList());
		
		if (!negatives.isEmpty())
			throw new NegativeNotAllowedException(negatives);
	}

	private static Matcher matcher(String numbers) {
		return Pattern.compile("(//\\[?)(.*?)(\\]?\\n)(.*)").matcher(numbers);
	}

}
