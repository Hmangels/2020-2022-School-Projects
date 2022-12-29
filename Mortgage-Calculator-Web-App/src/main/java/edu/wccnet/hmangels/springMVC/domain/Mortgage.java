package edu.wccnet.hmangels.springMVC.domain;

import org.springframework.stereotype.Component;


public class Mortgage {
	int principal;
	int downPayment;
	double interest;
	int loanTerm;
	//static int [][] arraytable;
	
	
	
	

	public int getPrincipal() {
		return principal;
	}



	public void setPrincipal(int principal) {
		this.principal = principal;
	}



	public int getDownPayment() {
		return downPayment;
	}



	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}



	public double getInterest() {
		return interest;
	}



	public void setInterest(double d) {
		this.interest = d;
	}



	public int getLoanTerm() {
		return loanTerm;
	}



	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	
	/*
	 * public static float calcMonthlyPayment(double principal, double interest,int
	 * loanTerm,double downpayment) { float monthlyPayment = (float)
	 * ((principal-downpayment) * (((interest/12) * (Math.pow(((interest/12)+1),
	 * (loanTerm * 12)))) / ((Math.pow(((interest/12)+1), (loanTerm * 12))) - 1)));
	 * return monthlyPayment; }
	 * 
	 * public static void displayAmorTable(double principal, double interest, int
	 * loanterm, double downpayment) { double outstandingBalance = principal -
	 * downpayment; double monthlyPayment =
	 * calcMonthlyPayment(principal,interest,loanterm, downpayment); double
	 * interestPaid; double principalPaid; double newBalance; int months = loanterm
	 * * 12; arraytable = new int[months][4];
	 * 
	 * 
	 * 
	 * for (int month = 0; month <= ((months)-1); month++) { interestPaid =
	 * outstandingBalance * (interest/12); principalPaid = monthlyPayment -
	 * interestPaid; newBalance = outstandingBalance - principalPaid;
	 * 
	 * 
	 * 
	 * arraytable[month][0] = (month+1); arraytable[month][1] = (int) principalPaid;
	 * arraytable[month][2] = (int) interestPaid; arraytable[month][3] = (int)
	 * outstandingBalance;
	 * 
	 * outstandingBalance = newBalance;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */




}