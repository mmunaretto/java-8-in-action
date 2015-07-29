package lambdas.observer;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject s = new ConcreteSubject();
		s.attach(new ConcreteObserver(s, "A"));
		s.attach(new ConcreteObserver(s, "B"));
		s.attach(new ConcreteObserver(s, "C"));

		s.setSubjectState("NEW");
		s.notifyObservers();
	}
}
