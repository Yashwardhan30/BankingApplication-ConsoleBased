import java.util.Scanner;

public class BankInherMain {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		Account acc=null;
		Address cAddr=null;
		System.out.println("----------WELCOME TO ABCD BANK----------");
		System.out.println("\nCREATE NEW ACCOUNT\n");
		System.out.println("Enter your details...\nID\nName\nMobile no.");
		int cId=sc.nextInt();
		String cName=sc.next();
		double cMob=sc.nextDouble();
		BankCustomer cust=new BankCustomer(cId, cName, cMob, acc, cAddr);
		
		System.out.println("Enter your Address...\nCity\nState\nPincode");
		String city=sc.next();
		String state=sc.next();
		int pincode=sc.nextInt();
		cAddr=new Address(city, state, pincode);
		cust.setcAddr(cAddr);
		
		System.out.println("Enter Account details...\nAccount no.\nBalance\nCreate Password\nAccount Type(Savings/Current/Loan)");
		int accNo=sc.nextInt();
		float accBal=sc.nextFloat();
		String password=sc.next();
		String accType=sc.next();
		acc=new Account(accNo, accBal, password, accType);
		cust.setAcc(acc);
		
		if(accType.equalsIgnoreCase("Savings")) {
			System.out.println("Enter rate of interest");
			float intRate=sc.nextFloat();
			SavingAccount sa=new SavingAccount(accNo, accBal, password, accType, intRate);
			System.out.println(cust);
			System.out.println(sa);

		}else if(accType.equalsIgnoreCase("Current")) {
			System.out.println("Enter Company's Name\nEnter GST no.");
			String compName=sc.next();
			double GSTno=sc.nextDouble();
			CurrentAccount ca=new CurrentAccount(accNo, accBal, password, accType, compName, GSTno);
			System.out.println(cust);
			System.out.println(ca);

		}else if(accType.equalsIgnoreCase("Loan")) {
			System.out.println("Enter the following details...\nCIBIL Score\nLoan Amount\nLoan Type(Car/Education/Housing)");
			int cibilScore=sc.nextInt();
			float loanAmt=sc.nextFloat();
			String loanType=sc.next();
			LoanAccount la=new LoanAccount(accNo, accBal, password, accType, cibilScore, loanAmt, loanType);
			if(loanType.equalsIgnoreCase("Car")) {
				System.out.println("Price of Car\nNo. of Installments\nYears for Repayment");
				float carPrice=sc.nextFloat();
				int noOfInst=sc.nextInt();
				int noOfYears=sc.nextInt();
				CarLoan cl=new CarLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, carPrice, noOfInst, noOfYears);
				System.out.println(cust);
				System.out.println(la);
				System.out.println(cl);
				
			}else if(loanType.equalsIgnoreCase("Education")) {
				System.out.println("Total Years of Study\nTotal Fees\nLast Year's Score");
				int yrsOfStudy=sc.nextInt();
				float tFees=sc.nextFloat();
				float lastYrScore=sc.nextFloat();
				EducationLoan el=new EducationLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, tFees, yrsOfStudy, lastYrScore);
				System.out.println(cust);
				System.out.println(la);
				System.out.println(el);
				
			}else if(loanType.equalsIgnoreCase("Housing")) {
				System.out.println("Price of House\nArea of House\nNo. of Installments\nYears for Repayment");
				float hPrice=sc.nextFloat();
				float hArea=sc.nextFloat();
				int noOfInst=sc.nextInt();
				int noOfYears=sc.nextInt();
				HousingLoan hl=new HousingLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, hPrice, hArea, noOfInst, noOfYears);
				System.out.println(cust);
				System.out.println(la);
				System.out.println(hl);
				
			}
			
		}
		
	}
}
