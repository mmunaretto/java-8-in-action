package lambdas.gameoflife;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class LocationTest {
	private static final String HERE = "here";
	private PrintStream out = mock(PrintStream.class);

	@Test
	public void executeSomethingWhenLocationAreEquals() {
		Location a = new Location(1, 1);
		Location b = new Location(1, 1);
		a.equals(b, () -> {
			out.println(HERE);
		});
		verify(out).println(HERE);
	}

	@Test
	public void dontExecuteNothingWhenLocationAreDifferent() {
		Location a = new Location(1, 2);
		Location b = new Location(1, 1);
		a.equals(b, () -> {
			out.println(HERE);
		});
		verify(out, never()).println(HERE);
	}

}
