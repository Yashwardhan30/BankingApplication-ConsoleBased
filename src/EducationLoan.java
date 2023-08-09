
public class EducationLoan extends LoanAccount {
	private float tFees;
	private int yrsOfStudy;
	private float lastYrScore;
	
	public EducationLoan(int accNo, float accBal, String password, String accType, int cibilScore, float loanAmt,
			String loanType, float tFees, int yrsOfStudy, float lastYrScore) {
		super(accNo, accBal, password, accType, cibilScore, loanAmt, loanType);
		this.tFees = tFees;
		this.yrsOfStudy = yrsOfStudy;
		this.lastYrScore = lastYrScore;
	}

	@Override
	public String toString() {
		return "Total Years of Study: "+getYrsOfStudy()+"\nTotal Fees: "+gettFees()+"\nLast Year's Score: "+getLastYrScore();
	}

	public float gettFees() {
		return tFees;
	}

	public void settFees(float tFees) {
		this.tFees = tFees;
	}

	public int getYrsOfStudy() {
		return yrsOfStudy;
	}

	public void setYrsOfStudy(int yrsOfStudy) {
		this.yrsOfStudy = yrsOfStudy;
	}

	public float getLastYrScore() {
		return lastYrScore;
	}

	public void setLastYrScore(float lastYrScore) {
		this.lastYrScore = lastYrScore;
	}
	
}
