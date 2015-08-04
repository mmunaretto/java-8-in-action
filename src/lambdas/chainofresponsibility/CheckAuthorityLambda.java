package lambdas.chainofresponsibility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CheckAuthorityLambda {

	public static void main(String[] args) {
		UnaryOperator<PurchaseRequest> managerPower =
				(PurchaseRequest request) -> {
					return process(request, 0, 5000, "Manager");
				};

		UnaryOperator<PurchaseRequest> directorPower =
				(PurchaseRequest request) -> {
					return process(request, 5000, 10000, "Director");
				};

		UnaryOperator<PurchaseRequest> vicePresidentPower =
				(PurchaseRequest request) -> {
					return process(request, 10000, 20000, "Vice President");
				};

		UnaryOperator<PurchaseRequest> presidentPower =
				(PurchaseRequest request) -> {
					return process(request, 20000, 30000, "President");
				};

		UnaryOperator<PurchaseRequest> boardMeetingPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() >= 30000) {
						System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
					}
					return request;
				};

		Function<PurchaseRequest, PurchaseRequest> pipeline = managerPower
				.andThen(directorPower)
				.andThen(vicePresidentPower)
				.andThen(presidentPower)
				.andThen(boardMeetingPower);

		try {
			while (true) {
				System.out.println("Enter the amount to check who should approve your expenditure.");
				System.out.print(">");
				double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
				pipeline.apply(new PurchaseRequest(d, "General"));
			}
		} catch (Exception e) {
			System.exit(1);
		}
	}

	private static PurchaseRequest process(PurchaseRequest request, double lowerBound, double upperBound, String office) {
		double amount = request.getAmount();
		if (amount >= lowerBound && amount < upperBound) {
			System.out.printf("%s will approve $%s.\n", office, amount);
		}
		return request;
	}

}
