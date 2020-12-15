/**
 * Interface of account.
 *
 * @author Sepehr Mansouri
 * @version 1.0
 */
public interface Account {
    /**
     * Interface of function that returns balance.
     * @return account balance as double.
     */
    double getBalance();

    /**
     * Interface of function that Sets balance to parameter.
     *
     * @param newBalance double value of new balance.
     */
    void setBalance(double newBalance);
    /**
     * Interface of function to Updates balance by adding deposit.
     * @param amount Deposit amount.
     * @param depositType Deposit type.
     * @return New account balance.
     * @throws IllegalDepositException throws if deposit type is not valid.
     */
    double deposit(double amount, final DepositType depositType) throws IllegalDepositException;

    /**
     * Interface of function to withdraw money from account.
     * @param amount amount to withdraw as double.
     * @return The new balance as double.
     * @throws BalanceExceedsOverDraftProtectionException if new balance is less than overdraft.
     */
    double withdraw(double amount) throws BalanceExceedsOverDraftProtectionException;
    /**
     * Interface of function to return overdraft amount.
     * @return overdraft amount as a double.
     */
    double getOverdraftProtectionAmount();
    /**
     * Sets overDraftProtectionAmount.
     * @param overdraftLevel New overdraft amount as a double.
     */
    void setOverdraftProtectionAmount(double overdraftLevel);
    /**
     * Interface of function that returns account type.
     * @return type of account as AccountType.
     */
    AccountType getAccountType();
    /**
     * Interface of function that returns account number.
     * @return account number as int.
     */
    int getAccountNumber();
    /**
     * Interface of function that returns email.
     * @return email as string.
     */
    String getEmail();
    /**
     * Interface of function that return first name.
     * @return first name as a string.
     */
    String getFirstName();
    /**
     * Interface of function that returns middle name.
     * @return middle name as string.
     */
    String getMiddleName();
    /**
     * Interface of function that returns last name.
     * @return last name as string.
     */
    String getLastName();
    /**
     * Interface of function that Sets email to new email.
     * @param email new email as string.
     */
    void setEmail(String email);
    /**
     * Interface of function that gets password.
     * @return password as a string.
     */
    String getPassword();

    /**
     * Interface of function that Sets password to new password.
     * @param password password as string.
     */
    void setPassword(String password);
}
