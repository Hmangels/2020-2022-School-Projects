package edu.wccnet.hmangels.springMVC.domain;


import org.springframework.stereotype.Component;

@Component
public class mortgageService {
	
	public float calcMonthlyPayment(double principal, double interest,int loanTerm,double downpayment) {
		float monthlyPayment = (float) ((principal-downpayment) * (((interest/12) * (Math.pow(((interest/12)+1), (loanTerm * 12)))) / ((Math.pow(((interest/12)+1), (loanTerm * 12))) - 1)));
		return monthlyPayment;
	}
	
	public int[][] AmorTable(double principal, double interest, int loanterm, double downpayment) {
		double outstandingBalance = principal - downpayment;
		double monthlyPayment = calcMonthlyPayment(principal,interest,loanterm, downpayment);
		double interestPaid;
		double principalPaid;
		double newBalance;
		int months = loanterm * 12;
		int [][] arraytable = new int[(months)][4];
		
		
		for (int i =0; i <= months-1; i++) {
			interestPaid = outstandingBalance * (interest/12);
			principalPaid = monthlyPayment - interestPaid;
			newBalance = outstandingBalance - principalPaid;
			
			
			
			arraytable[i][0] = i+1;
			arraytable[i][1] = (int) principalPaid;
			arraytable[i][2] = (int) interestPaid;
			arraytable[i][3] = (int) outstandingBalance;
			
			outstandingBalance = newBalance;
			
			
			
		}
		return arraytable;
		
	}
	
	

}
