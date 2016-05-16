/**
 * Bank
 * 
 * @author Vincent Huang
 */
package bank;

import java.util.*;

public class Bank {

	/**記錄帳戶*/
	private Map<Integer, BankAccount> accounts = new TreeMap();

	/**
	 * 新增帳戶
	 *
	 * @param accountNumber 帳號
	 * @param initialBalance 開戶金額
	 */
	public void addAccount(Integer accountNumber, double initialBalance) {
		if(!accounts.containsKey(accountNumber)) {
			accounts.put(accountNumber, new BankAccount(initialBalance));
		}
	}

	/**
	 * 存款
	 *
	 * @param accountNumber 帳號
	 * @param amount 存款金額
	 * @see bank.BankAccount#deposit(double)
	 */
	public void deposit(int accountNumber, double amount) {
           	accounts.get(accountNumber).deposit(amount);
	}

	/**
	 * 提款
	 *
	 * @param accountNumber 帳號
	 * @param amount 提款金額
	 * @see bank.BankAccount#withdraw(double)
	 */
	public void withdraw(int accountNumber, double amount) {
          		accounts.get(accountNumber).withdraw(amount);
	}

	/**
	 * 取得指定帳戶餘額
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#getBalance()
	 * @return 帳戶餘額
	 */
	public double getBalance(int accountNumber) {
            	return accounts.get(accountNumber).getBalance();
        	}

        	/**
	 * 凍結指定帳戶
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#suspend()
	 */
	public void suspendAccount(int accountNumber) {
           	accounts.get(accountNumber).suspend();
	}

	/**
	 * 重新開啟指定帳戶
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#reOpen()
	 */
	public void reOpenAccount(int accountNumber) {
            	accounts.get(accountNumber).reOpen();
	}

	/**
	 * 關閉指定帳戶
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#close()
	 */
	public void closeAccount(int accountNumber) {
            	accounts.get(accountNumber).close();
	}

	/**
	 * 取得指定帳戶狀態
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#getStatus()
	 * @return 帳戶狀態
	 */
	public String getAccountStatus(int accountNumber) {
            	return accounts.get(accountNumber).getStatus();
	}

	/**
	 * 取得指定帳戶交易記錄
	 *
	 * @param accountNumber 指定帳號
	 * @see bank.BankAccount#getTransactions()
	 * @return 交易記錄
	 */
	public String summarizeAccountTransactions(int accountNumber) {
            	return "Account #" + accountNumber + " transactions:\n" + 
            	accounts.get(accountNumber).getTransactions();
	}

	/**
	 * 彙總銀行所有帳戶資料
	 *
	 * @see bank.BankAccount#getBalance()
	 * @see bank.BankAccount#retrieveNumberOfTransactions()
	 * @see bank.BankAccount#getStatus()
	 * @return 所有帳戶帳號、餘額、交易次數、狀態
	 */
	public String summarizeAllAccounts() {
           	StringBuilder output = new StringBuilder();
            	for(Integer value : accounts.keySet()) {
                		output.append(String.format("%-15d%-15.2f%-15d%-15s", value, 
                        	accounts.get(value).getBalance(), 
                        	accounts.get(value).retrieveNumberOfTransactions(), 
                        	accounts.get(value).getStatus())).append("\n");
            }
           	return String.format("%-15s%-15s%-15s%-15s%n", "Account", "Balance", 
           	         "#Transactions", "Status") + output.toString() + 
           	         "End of Account Summary";
        }
}
