package lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1878928700039676513L;

	private String message;

	public NegativeNotAllowedException(List<Integer> negatives) {
		message = negatives.stream()
				.map(i -> i.toString())
				.collect(Collectors.joining(","));
	}

	@Override
	public String getMessage() {
		return message;
	}
}
