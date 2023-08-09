package ExceptionHandeling;

public class MinAgeError extends Exception {

	public String toString() {
		return "Your Age is less than 18";
	}
}
