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
	 * 新增支票帳戶
	 *
	 * @param accountNumber 帳號
	 * @param initialBalance 開戶金額
	 */
	public void addCheckingAccount(Integer accountNumber, double initialBalance) {
		if(!accounts.containsKey(accountNumber)) {
			accounts.put(accountNumber, new CheckingAccount(initialBalance));
		}
	}

	/**
	 * 新增儲蓄帳戶
	 *
	 * @param accountNumber 帳號
	 * @param initialBalance 開戶金額
	 * @param interestRate 利率
	 */
	public void addSavingsAccount(Integer accountNumber, double initialBalance, double interestRate) {
		if(!accounts.containsKey(accountNumber)) {
			accounts.put(accountNumber, new SavingsAccount(initialBalance, interestRate));
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
	 * 結算指定儲蓄帳戶利息
	 *
	 * @param accountNumber 指定帳號
	 */
	public void addInterest(int accountNumber) {
		if(accounts.get(accountNumber) instanceof SavingsAccount) {
			accounts.get(accountNumber).addInterest();
		}
	}

	/**
	 * 結算指定帳戶費用
	 *
	 * @param accountNumber 指定帳號
	 */
	public void deductFee(int accountNumber) {
		if(accounts.get(accountNumber) instanceof CheckingAccount) {
			accounts.get(accountNumber).deductFee();
		}
	}

	/**
	 * 轉帳
	 *
	 * @param withdrawAcctNum 轉出帳號
	 * @param depositAcctNum 轉入帳號
	 * @param amount 金額
	 */
	public void transfer(int withdrawAcctNum, int depositAcctNum, double amount) {
		if(accounts.get(withdrawAcctNum).getBalance() >= amount && accounts.get(withdrawAcctNum).isOpen() &&
			accounts.get(depositAcctNum).isOpen()) {
			accounts.get(withdrawAcctNum).withdraw(amount);
			accounts.get(depositAcctNum).deposit(amount);
		}
	}

	/**
	 * 比較帳戶餘額是否相等
	 *
	 * @param accountNumber1 指定比較帳號1
	 * @param accountNumber2 指定比較帳號2
	 * @return true or false
	 */
	public boolean areEqualAccounts(int accountNumber1, int accountNumber2) {
		return accounts.get(accountNumber1).equals(accounts.get(accountNumber2));
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

	public String accountType(int accountNumber) {
		if(accounts.get(accountNumber) instanceof CheckingAccount){
			return "checking";
		}
		if(accounts.get(accountNumber) instanceof SavingsAccount){
			return "savings";
		}
		return "unknown";
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
                		output.append(String.format("%-15d%-15s%-15.2f%-15d%-15s", value,
                		accountType(value), 
                        	accounts.get(value).getBalance(), 
                        	accounts.get(value).retrieveNumberOfTransactions(), 
                        	accounts.get(value).getStatus())).append("\n");
           }
           	return String.format("%-15s%-15s%-15s%-15s%-15s%n", "Account", "Type", 
           	         "Balance", "#Transactions", "Status") + output.toString() + 
           	         "End of Account Summary";
        	}    
}