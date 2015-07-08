package lambdas.strategy;

public class StrategyLambda {

	public static void main(String[] args) {
		Customer a = new Customer((double p) -> p);

		// Normal billing
		a.add(1.0, 1);

		// Start Happy Hour
		a.setStrategy((double p) -> p * 0.5);
		a.add(1.0, 2);

		// New Customer
		Customer b = new Customer((double p) -> p * 0.5);
		b.add(0.8, 1);
		// The Customer pays
		a.printBill();

		// End Happy Hour
		b.setStrategy((double p) -> p);
		b.add(1.3, 2);
		b.add(2.5, 1);
		b.printBill();
	}
}