package lambdas.strategy;

interface BillingStrategy {
	double getActPrice(double rawPrice);
}