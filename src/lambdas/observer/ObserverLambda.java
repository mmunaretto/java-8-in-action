package lambdas.observer;

public class ObserverLambda {
	public static void main(String[] args) {
		final ConcreteSubject s = new ConcreteSubject();
		s.attach(() -> {
			System.out.printf("Observer %s's new state is %s\n", "A", s.getSubjectState());
		});
		s.attach(() -> {
			System.out.printf("Observer %s's new state is %s\n", "B", s.getSubjectState());
		});
		s.attach(() -> {
			System.out.printf("Observer %s's new state is %s\n", "C", s.getSubjectState());
		});

		s.setSubjectState("NEW");
		s.notifyObservers();
	}
}
