/**
 * CheckingAccount
 * 
 * @author Vincent Huang
 */
package bank;

public class CheckingAccount extends BankAccount {
	private int withdrawals;

	/**
	 * CheckingAccount建構子，繼承至BankAccount
	 *
	 * @param initialBalance 開戶金額
	 */
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
	}

	/**
	 * 提款
	 *
	 * @param amount 提款金額
	 */
	public void withdraw(double amount) {
		super.withdraw(amount);
		if(isOpen() && amount > 0 && getBalance() > amount) {
			withdrawals++;
		}
	}

	/**
	 * 扣除月費
	 *
	 */
	public void deductFees() {
		final int MONTHLY_FEE = 4;

		if(getBalance() > MONTHLY_FEE) {
			super.withdraw(MONTHLY_FEE);
		}
	}
	public void monthEnd() {
		withdrawals = 0;
	}
}