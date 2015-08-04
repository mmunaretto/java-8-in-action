package lambdas.factory;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Complex {
	public static Complex fromCartesianFactory(double real, double imaginary) {
		return new Complex(real, imaginary);
	}

	public static Complex fromPolarFactory(double modulus, double angle) {
		return new Complex(modulus * cos(angle), modulus * sin(angle));
	}

	private Complex(double a, double b) {
		// ...
	}

	public static void main(String[] args) {
		Complex product = Complex.fromPolarFactory(1, PI);
		// do something
}
