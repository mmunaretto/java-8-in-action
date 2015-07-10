package lambdas.strategy;

// Normal billing strategy (unchanged price)
public class NormalStrategy implements BillingStrategy {

	@Override
	public double getActPrice(double rawPrice) {
		return rawPrice;
	}

}