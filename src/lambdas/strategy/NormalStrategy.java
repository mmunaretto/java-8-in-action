package lambdas.strategy;

// Normal billing strategy (unchanged price)
class NormalStrategy implements BillingStrategy {

	@Override
	public double getActPrice(double rawPrice) {
		return rawPrice;
	}

}