package lambdas.chainofresponsibility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CheckAuthorityLambda {

	public static void main(String[] args) {
		UnaryOperator<PurchaseRequest> managerPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() < 10 * PurchasePower.BASE) {
						System.out.println("Manager will approve $" + request.getAmount());
					}
					return request;
				};

		UnaryOperator<PurchaseRequest> directorPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() >= 10 * PurchasePower.BASE && request.getAmount() < 20 * PurchasePower.BASE) {
						System.out.println("Director will approve $" + request.getAmount());
					}
					return request;
				};

		UnaryOperator<PurchaseRequest> vicePresidentPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() >= 20 * PurchasePower.BASE && request.getAmount() < 40 * PurchasePower.BASE) {
						System.out.println("Vice President will approve $" + request.getAmount());
					}
					return request;
				};

		UnaryOperator<PurchaseRequest> presidentPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() >= 40 * PurchasePower.BASE && request.getAmount() < 60 * PurchasePower.BASE) {
						System.out.println("Vice President will approve $" + request.getAmount());
					}
					return request;
				};

		UnaryOperator<PurchaseRequest> boardMeetingPower =
				(PurchaseRequest request) -> {
					if (request.getAmount() >= 60 * PurchasePower.BASE) {
						System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
					}
					return request;
				};

		Function<PurchaseRequest, PurchaseRequest> pipeline = managerPower.andThen(directorPower).andThen(vicePresidentPower)
				.andThen(presidentPower).andThen(boardMeetingPower);

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

}
