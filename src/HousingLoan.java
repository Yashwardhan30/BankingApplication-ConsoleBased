
public class HousingLoan extends LoanAccount {
	private float hPrice;
	private float hArea;
	private int noOfInst;
	private int noOfYears;
	
	public HousingLoan(int accNo, float accBal, String password, String accType, int cibilScore, float loanAmt,
			String loanType, float hPrice, float hArea, int noOfInst, int noOfYears) {
		super(accNo, accBal, password, accType, cibilScore, loanAmt, loanType);
		this.hPrice = hPrice;
		this.hArea = hArea;
		this.noOfInst = noOfInst;
		this.noOfYears = noOfYears;
	}

	@Override
	public String toString() {
		return "Price of House: "+gethPrice()+"\nArea of House: "+gethArea()+"\nNo. of Installments: "+getNoOfInst()+"\nYears for Repayment: "+getNoOfYears();
	}

	public float gethPrice() {
		return hPrice;
	}
	public void sethPrice(float hPrice) {
		this.hPrice = hPrice;
	}
	public float gethArea() {
		return hArea;
	}
	public void sethArea(float hArea) {
		this.hArea = hArea;
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
