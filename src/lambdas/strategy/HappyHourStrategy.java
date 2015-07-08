package lambdas.strategy;

// Strategy for Happy hour (50% discount)
class HappyHourStrategy implements BillingStrategy {

	@Override
	public double getActPrice(double rawPrice) {
		return rawPrice * 0.5;
	}

}