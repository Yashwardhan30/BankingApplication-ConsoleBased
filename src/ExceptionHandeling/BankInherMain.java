package ExceptionHandeling;
import java.util.Scanner;

public class BankInherMain {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		Account acc=null;
		Address cAddr=null;

		System.out.println("----------WELCOME TO ABCD BANK----------");
		System.out.println("\nCREATE NEW ACCOUNT\n");
		System.out.println("Enter your details...\nID\nName\nAge");
		int cId=sc.nextInt();
		String cName=sc.next();
		double cMob=sc.nextDouble();
		BankCustomer cust=new BankCustomer(cId, cName, cMob, null, cAddr);

		System.out.println("Enter your Address...\nCity\nState\nPincode");
		String city=sc.next();
		String state=sc.next();
		int pincode=sc.nextInt();
		cAddr=new Address(city, state, pincode);
		cust.setcAddr(cAddr);

		System.out.println("How many Accounts you want to create...");
		int n=sc.nextInt();
		Account accArr[]=new Account[n];

		for(int i=0;i<n;i++) {

			System.out.println("\nEnter Account "+(i+1)+" details...\nAccount no.\nBalance\nCreate Password\nAccount Type(Savings/Current/Loan)");
			int accNo=sc.nextInt();
			float accBal=sc.nextFloat();
			String password=sc.next();
			String accType=sc.next();
			
			try {
				if(accBal<1000) {
					throw new MinBalError();
				}
			}
			catch(MinBalError ex) {
				System.err.println("Exception is: "+ex);
				i--;
			}
			
			try {
				if(cMob<18) {
					throw new MinAgeError();
				}
			}
			catch(MinAgeError ex) {
				System.err.println("Exception is: "+ex);
				i--;
			}	

			
			if(accType.equalsIgnoreCase("Savings")) {
				System.out.println("Enter rate of interest");
				float intRate=sc.nextFloat();
				acc=new SavingAccount(accNo, accBal, password, accType, intRate);

			}else if(accType.equalsIgnoreCase("Current")) {
				System.out.println("Enter Company's Name\nEnter GST no.");
				String compName=sc.next();
				double GSTno=sc.nextDouble();
				acc=new CurrentAccount(accNo, accBal, password, accType, compName, GSTno);

			}else if(accType.equalsIgnoreCase("Loan")) {
				System.out.println("Enter the following details...\nCIBIL Score\nLoan Amount\nLoan Type(Car/Education/Housing)");
				int cibilScore=sc.nextInt();
				float loanAmt=sc.nextFloat();
				String loanType=sc.next();
				if(loanType.equalsIgnoreCase("Car")) {
					System.out.println("Price of Car\nNo. of Installments\nYears for Repayment");
					float carPrice=sc.nextFloat();
					int noOfInst=sc.nextInt();
					int noOfYears=sc.nextInt();
					acc=new CarLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, carPrice, noOfInst, noOfYears);

				}else if(loanType.equalsIgnoreCase("Education")) {
					System.out.println("Total Years of Study\nTotal Fees\nLast Year's Score");
					int yrsOfStudy=sc.nextInt();
					float tFees=sc.nextFloat();
					float lastYrScore=sc.nextFloat();
					acc=new EducationLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, tFees, yrsOfStudy, lastYrScore);

				}else if(loanType.equalsIgnoreCase("Housing")) {
					System.out.println("Price of House\nArea of House\nNo. of Installments\nYears for Repayment");
					float hPrice=sc.nextFloat();
					float hArea=sc.nextFloat();
					int noOfInst=sc.nextInt();
					int noOfYears=sc.nextInt();
					acc=new HousingLoan(accNo, accBal, password, accType, cibilScore, loanAmt, loanType, hPrice, hArea, noOfInst, noOfYears);
					
				}
			}
			accArr[i]=acc;
			cust.setAcc(accArr);

		}
		
		display(cust);
		
		System.out.println("\n\n\n\n-------------------------------");
		System.out.println("----------TRANSACTION----------");
		
		System.out.println("Enter Account Number");
		int search1=sc.nextInt();
		Account temp1=searchAcc(accArr, search1);
		if(temp1!=null) {
			System.out.println("\nWELCOME "+cust.getcName()+" FOR TRANSACTION...");
			System.out.println("Enter Password to continue...");
			String password=sc.next();
			if(password.equals(temp1.getPassword())) {
				System.out.println("1-Withdraw\n2-Deposit");
				System.out.println("Enter your choice");
				int ch1=sc.nextInt();
				switch(ch1) {
				case 1:
					System.out.println("Enter Amount you want to Withdraw");
					float amtw=sc.nextFloat();
					if(temp1.getAccBal()-amtw>=0) {
						acc.withdraw(temp1, amtw);
					}else {
						System.out.println("INSUFFICIENT BALANCE");
					}
					break;

				case 2:
					System.out.println("Enter Amount you want to Deposit");
					float amtd=sc.nextFloat();
					acc.deposit(temp1, amtd);
					break;
				}	
			}else {
				System.out.println("Incorrect Password");
			}
		}else {
			System.out.println("Invalid Account Number");
		}

	}

	
	public static Account searchAcc(Account[] accarr, int search) {
		Account temp=null;
		for(int i=0;i<accarr.length;i++) {
			if(accarr[i].getAccNo()==search) {
				temp=accarr[i];
			}
		}
		return temp;
	}
	
	
	public static void display(BankCustomer cust) {
		System.out.println("================================================================================================================================");
		System.out.println(cust);
		
		for(int i=0;i<cust.getAcc().length;i++) {
			
			if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Savings")) {
				SavingAccount sa=(SavingAccount) cust.getAcc()[i];
				System.out.println(cust);
				System.out.println("\n\nAccount no.: "+cust.getAcc()[i].getAccNo()+"\nAccount Type: "+cust.getAcc()[i].getAccType()+"\nBalance: Rs."+cust.getAcc()[i].getAccBal());
				System.out.println(sa);
				System.out.println("Interest Rate"+sa.getIntRate());

			}else if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Current")) {
				CurrentAccount ca=(CurrentAccount) cust.getAcc()[i];
				System.out.println(cust);
				System.out.println("\n\nAccount no.: "+cust.getAcc()[i].getAccNo()+"\nAccount Type: "+cust.getAcc()[i].getAccType()+"\nBalance: Rs."+cust.getAcc()[i].getAccBal());
				System.out.println(ca);

			}else if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Loan")) {
				LoanAccount la=(LoanAccount) cust.getAcc()[i];
				if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Car")) {
					CarLoan cl=(CarLoan) cust.getAcc()[i];
					System.out.println(cust);
					System.out.println("\n\nAccount no.: "+cust.getAcc()[i].getAccNo()+"\nAccount Type: "+cust.getAcc()[i].getAccType()+"\nBalance: Rs."+cust.getAcc()[i].getAccBal());
					System.out.println(la);
					System.out.println(cl);

				}else if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Education")) {
					EducationLoan el=(EducationLoan) cust.getAcc()[i];
					System.out.println(cust);
					System.out.println("\n\nAccount no.: "+cust.getAcc()[i].getAccNo()+"\nAccount Type: "+cust.getAcc()[i].getAccType()+"\nBalance: Rs."+cust.getAcc()[i].getAccBal());
					System.out.println(la);
					System.out.println(el);

				}else if(cust.getAcc()[i].getAccType().equalsIgnoreCase("Housing")) {
					HousingLoan hl=(HousingLoan) cust.getAcc()[i];
					System.out.println(cust);
					System.out.println("\n\nAccount no.: "+cust.getAcc()[i].getAccNo()+"\nAccount Type: "+cust.getAcc()[i].getAccType()+"\nBalance: Rs."+cust.getAcc()[i].getAccBal());
					System.out.println(la);
					System.out.println(hl);

				}
			}
		}
	}
}