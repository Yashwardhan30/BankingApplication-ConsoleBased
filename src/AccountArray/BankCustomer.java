package AccountArray;

public class BankCustomer {

	private int cId;
	private String cName;
	private double cMob;
	private Account[] acc;
	private Address cAddr;
	public BankCustomer(int cId, String cName, double cMob, Account[] acc, Address cAddr) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cMob = cMob;
		this.acc = acc;
		this.cAddr = cAddr;
	}
	@Override
	public String toString() {
		return "\nCustomer Id: "+getcId()+"\nCustomer Name: "+getcName()+"\nMobile no.: "+getcMob()+
				"\n\nAddress: "+getcAddr().getCity()+", "+getcAddr().getState()+", "+getcAddr().getPincode();
	}

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public double getcMob() {
		return cMob;
	}
	public void setcMob(double cMob) {
		this.cMob = cMob;
	}
	public Account[] getAcc() {
		return acc;
	}
	public void setAcc(Account[] acc) {
		this.acc = acc;
	}
	public Address getcAddr() {
		return cAddr;
	}
	public void setcAddr(Address cAddr) {
		this.cAddr = cAddr;
	}

}
