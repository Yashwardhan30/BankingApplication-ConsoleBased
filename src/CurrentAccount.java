
public class CurrentAccount extends Account {

	private String compName;
	private double GSTno;
	public CurrentAccount(int accNo, float accBal, String password, String accType, String compName, double gSTno) {
		super(accNo, accBal, password, accType);
		this.compName = compName;
		GSTno = gSTno;
	}
	
	@Override
	public String toString() {
		return "Company Name: "+getCompName()+"\nCompany GST no.: "+getGSTno();
	}

	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public double getGSTno() {
		return GSTno;
	}
	public void setGSTno(double gSTno) {
		GSTno = gSTno;
	}
	
}
