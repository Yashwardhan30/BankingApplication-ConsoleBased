package AccountTransaction;

public class SavingAccount extends Account {

	private float intRate;

	public SavingAccount(int accNo, float accBal, String password, String accType, float intRate) {
		super(accNo, accBal, password, accType);
		this.intRate = intRate;
	}

	@Override
	public String toString() {
		return "Rate of Interest: "+getIntRate()+"%";
	}

	public float getIntRate() {
		return intRate;
	}

	public void setIntRate(float intRate) {
		this.intRate = intRate;
	}

		
}
