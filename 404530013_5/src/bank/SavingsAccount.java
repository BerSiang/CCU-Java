/**
 * SavingsAccount
 * 
 * @author Vincent Huang
 */
package bank;

public class SavingsAccount extends BankAccount {
	private double interestRate;
	private double minBalance;

	/**
	 * SavingsAccount建構子，繼承至BankAccount
	 *
	 * @param initialBalance 開戶金額
	 * @param interestRate 利率
	 */
	public SavingsAccount(double initialBalance, double interestRate) {
		super(initialBalance);
		this.interestRate = interestRate;
	}

	/**
	 * 設置利率
	 *
	 * @param rate 利率
	 */
	public void setInterestRate(double rate) {
		interestRate = rate;
	}

	/**
	 * 提款
	 *
	 * @param amount 提款金額
	 */
	public void withdraw(double amount) {
		super.withdraw(amount);
		double balance = getBalance();
		if(balance < minBalance) {
			minBalance = balance;
		}
	}

	/**
	 * 結算利率
	 *
	 */
	public void addInterest() {
		double interest = minBalance * interestRate / 100;
		deposit(interest);
		minBalance = getBalance();
	}
	public void monthEnd() {
		addInterest();
	}
}