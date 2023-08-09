
public class Account {

	private int accNo;
	private float accBal;
	private String password;
	private	String accType;
	public Account(int accNo, float accBal, String password, String accType) {
		super();
		this.accNo = accNo;
		this.accBal = accBal;
		this.password = password;
		this.accType = accType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
}
