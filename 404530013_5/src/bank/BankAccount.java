/**
 * BankAccount
 * 
 * @author Vincent Huang
 */
package bank;

import java.util.*;

public class BankAccount {
    	/**帳戶狀態*/
	final String open = "open";
	final String suspend = "suspended";
	final String close = "closed";
	private String status;

	/**帳戶餘額*/
	private double balance;

	/**交易記錄*/
	private ArrayList<Double> cashFlow;

	/**
	 * BankAccount建構子，預設帳戶狀態為open、balance = 0，初始化cashFlow。
	 *
	 * @param amount 開戶金額
	 */
	public BankAccount(double amount) {
		this.status = open;
		this.cashFlow = new ArrayList<>();
		this.balance = 0;
		deposit(amount);
	}

	/**
	 * 存款
	 *
	 * @param amount 存款金額
	 */
	public void deposit(double amount) {
		if(isOpen() && amount > 0) {
			addTransaction(amount);
			balance += amount;
		}
	}

	/**
	 * 提款
	 *
	 * @param amount 提款金額
	 */
	public void withdraw(double amount) {
		if(isOpen() && amount > 0 && balance > amount) {
			addTransaction(-amount);
			balance -= amount;
		}
	}

	/**
	 * 將凍結帳戶重新開啟
	 *
	 * @see #setStatus(String)
	 */
	public void reOpen() {
		setStatus(open);
	}

	/**
	 * 凍結帳戶
	 *
	 * @see #setStatus(String)
	 */
	public void suspend() {
		setStatus(suspend);
	}

	/**
	 * 關閉帳戶
	 *
	 * @see #setStatus(String)
	 */
	public void close() {
		withdraw(balance);
		setStatus(close);
	}

	/**
	 * 確認帳戶狀態是否為開啟
	 *
	 * @return true or false
	 */
	public boolean isOpen() {
		return status.equals(open);
	}

	/**
	 * 確認帳戶狀態是否為凍結
	 *
	 * @return true or false
	 */
	public boolean isSuspended() {
		return status.equals(suspend);
	}

	/**
	 * 確認帳戶狀態是否為關閉
	 *
	 * @return true or false
	 */
	public boolean isClosed() {
		return status.equals(close);
	}

	/**
	 * 加入交易記錄
	 *
	 * @param amount 交易金額
	 */
	public void addTransaction(double amount) {
		cashFlow.add(amount);
	}

	/**
	 * 取得交易記錄
	 *
	 * @return 交易記錄
	 */
	public String getTransactions() {
		int i = 1;
		StringBuilder transactions = new StringBuilder();
		String pattern = "%s. %-10.2f%n";
		for(Double transaction : cashFlow) {
			String tmp = String.format(pattern, i++, transaction);
			transactions.append(tmp);
		}
		transactions.append("Current balance = " + getBalance());
		return transactions.toString();
	}

	/**
	 * 取得交易記錄次數
	 *
	 * @return 交易記錄次數
	 */
	public int retrieveNumberOfTransactions() {
            	return cashFlow.size();
	}

	/**
	 * 取得帳戶餘額
	 *
	 * @return 帳戶餘額
	 */
	public double getBalance() {
            	return balance;
	}

	/**
	 * 取得帳戶狀態
	 *
	 * @return 帳戶狀態
	 */
	public String getStatus() {
            	return status;
	}

	/**
	 * 設置帳戶狀態
	 *
	 * @param status 帳戶狀態
	 */
	private void setStatus(String status) {
		if (!isClosed()) {
			this.status = status;
		}
	}

	/**
	 * 比較帳戶餘額是否相等
	 *
	 * @param o 比較帳戶
	 */
	public boolean equals(Object o) {
		BankAccount tmp = (BankAccount) o;
		if(getBalance() - tmp.getBalance() <= 0.01 && getBalance() - tmp.getBalance() >= -0.01) {
			return true;
		}
		return false;
	}

	public void monthEnd() {
		
	}
        
        public void deductFee(){
            
        }
        
        public void addInterest() {
            
        }
}
