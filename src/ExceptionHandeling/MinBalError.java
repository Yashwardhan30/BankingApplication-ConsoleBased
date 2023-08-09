package ExceptionHandeling;

public class MinBalError extends Exception {

	public String toString() {
		return "Your Account Balance is less than Rs.1000";
	}
}
