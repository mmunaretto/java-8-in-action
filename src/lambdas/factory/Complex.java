package lambdas.factory;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.function.BiFunction;

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
		Complex productWithFactory = Complex.fromPolarFactory(1, PI);
		// do something
		BiFunction<Integer, Double, Complex> constructorWithLambda = Complex::new;
		Complex productWithLambda = constructorWithLambda.apply(1, PI);
	}
}
