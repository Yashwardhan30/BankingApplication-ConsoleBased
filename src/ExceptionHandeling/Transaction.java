package ExceptionHandeling;

public abstract class Transaction {

	public abstract void deposit(Account temp, float amt);
	public abstract void withdraw(Account temp, float amt);

}