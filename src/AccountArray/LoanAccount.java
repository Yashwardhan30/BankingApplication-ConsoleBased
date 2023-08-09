package AccountArray;

public class LoanAccount extends Account {
	private int cibilScore;
	private float loanAmt;
	private String loanType;
	public LoanAccount(int accNo, float accBal, String password, String accType, int cibilScore, float loanAmt,
			String loanType) {
		super(accNo, accBal, password, accType);
		this.cibilScore = cibilScore;
		this.loanAmt = loanAmt;
		this.loanType = loanType;
	}
	
	@Override
	public String toString() {
		return "CIBIL Score: "+getCibilScore()+"Loan Type: "+getLoanType()+"Loan Amount: "+getLoanAmt();
	}

	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public float getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(float loanAmt) {
		this.loanAmt = loanAmt;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

}
