package us.fatehi.system_exit_21;

public class Exiter {

	public static void main(String[] args) {

		System.err.printf("NOW RUNNING %s%n", Exiter.class);
		System.err.printf("Running with Java %s%n", System.getProperty("java.version"));

		System.exit(2);
	}

}
