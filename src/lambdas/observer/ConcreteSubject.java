package lambdas.observer;

public class ConcreteSubject extends Subject {
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String value) {
		subjectState = value;
	}
}