
public class CarLoan extends LoanAccount {
	private float carPrice;
	private int noOfInst;
	private int noOfYears;
	public CarLoan(int accNo, float accBal, String password, String accType, int cibilScore, float loanAmt,
			String loanType, float carPrice, int noOfInst, int noOfYears) {
		super(accNo, accBal, password, accType, cibilScore, loanAmt, loanType);
		this.carPrice = carPrice;
		this.noOfInst = noOfInst;
		this.noOfYears = noOfYears;
	}
	
	@Override
	public String toString() {
		return "Price of Car: "+getCarPrice()+"\nNo. of Installments"+getNoOfInst()+"\nYears for Repayment: "+getNoOfYears();
	}

	public float getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
	}
	public int getNoOfInst() {
		return noOfInst;
	}
	public void setNoOfInst(int noOfInst) {
		this.noOfInst = noOfInst;
	}
	public int getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

}
