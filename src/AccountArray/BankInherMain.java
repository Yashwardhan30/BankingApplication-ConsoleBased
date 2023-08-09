package AccountArray;
import java.beans.Customizer;
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
			

			accArr[i]=acc;
			cust.setAcc(accArr);

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
		}
		display(cust);
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