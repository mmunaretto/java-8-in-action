package lambdas.observer;

public class Client {
	public static void main(String[] args) {
		// Configure Observer structure
		ConcreteSubject s = new ConcreteSubject();
		s.attach(new ConcreteObserver(s, "A"));
		s.attach(new ConcreteObserver(s, "B"));
		s.attach(new ConcreteObserver(s, "C"));

		// Change subject and notify observers
		s.setSubjectState("NEW");
		s.notifyObservers();
	}
}
