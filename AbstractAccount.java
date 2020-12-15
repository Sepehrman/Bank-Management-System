import java.util.Objects;

enum AccountType {
    CHEQUINGS, SAVINGS
};

/**
 * Abstract of account.
 *
 * @author Sepehr Mansouri
 * @version 1.0
 */
abstract class AbstractAccount implements Account {
    private static final int EMPTY_ACCOUNT_BALANCE = 0;
    private final int accountNumber;
    private double overdraftProtectionLevel;
    private final AccountType accountType;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private double balance;

    AbstractAccount(final AccountType accountType, final int accountNumber) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    /**
     * Returns balance value of an empty account.
     *
     * @return int value of an empty account.
     */
    public static int getEmptyAccountBalance() {
        return EMPTY_ACCOUNT_BALANCE;
    }

    /**
     * Sets balance to parameter.
     *
     * @param newBalance double value of new balance.
     */
    public void setBalance(final double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Returns account balance.
     * @return balance as double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates balance by adding deposit.
     * @param amount Deposit amount.
     * @param depositType Deposit type.
     * @return New account balance.
     * @throws IllegalDepositException throws if deposit type is not valid.
     */
    public double deposit(final double amount, final DepositType depositType)
            throws IllegalDepositException {
        if (!isDepositTypeValid(depositType) || depositType == DepositType.Cheque) {
            throw new IllegalDepositException("" + "Deposit type is not valid,"
                    + " must be Cash, Or E_Transfer");
        }
        setBalance(getBalance() + amount);
        return getBalance();
    }

    /**
     * Returns Overdraft Protection Amount.
     * @return Overdraft Protection amount as a double.
     */
    public double getOverdraftProtectionAmount() {
        return overdraftProtectionLevel;
    }

    /**
     * Sets overDraftProtectionAmount.
     * @param overdraftLevel New overdraft amount as a double.
     */
    public void setOverdraftProtectionAmount(final double overdraftLevel) {
        this.overdraftProtectionLevel = overdraftLevel;
    }

    /**
     * Returns type of account.
     * @return AccountType.
     */
    public final AccountType getAccountType() {
        return accountType;
    }

    /**
     * Returns number of the account.
     * @return Number of the account as an int.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Checks if the deposit type is valid.
     * @param deposit Deposit type.
     * @return Boolean value of whether or not deposit type is valid.
     */
    public boolean isDepositTypeValid(final DepositType deposit) {
        for (DepositType type: DepositType.values()) {
            if (type.equals(deposit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns Email.
     * @return email as String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns firstName.
     * @return first name as string.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Returns middleName.
     * @return middle name as string.
     */
    public String getMiddleName() {
        return firstName;
    }
    /**
     * Returns lastName.
     * @return last name as string.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets email to new email.
     * @param email new email as string.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Returns password as String.
     * @return password as string.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password to new password.
     * @param password password as string.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * String representation of object.
     * @return String representation of object.
     */
    @Override
    public String toString() {
        return "Bank(AccountType="
                + accountType
                + ", AccountNumber=" + accountNumber
                + ", balance=" + balance
                + ", firstName=" + firstName
                + ", middleName=" + middleName
                + ", lastName=" + lastName
                + ", email=" + email
                + ", password=" + password + ","
                + "overdraftProtectionLevel=" + overdraftProtectionLevel + ")";
    }
    /**
     * Checks if object is equal to another object.
     * @param o Other object.
     * @return Boolean value.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractAccount that = (AbstractAccount) o;
        return accountNumber == that.accountNumber
                && Double.compare(that.overdraftProtectionLevel, overdraftProtectionLevel) == 0
                && Double.compare(that.balance, balance) == 0
                && accountType == that.accountType
                && firstName.equals(that.firstName)
                && Objects.equals(middleName, that.middleName)
                && lastName.equals(that.lastName)
                && email.equals(that.email)
                && password.equals(that.password);
    }

    /**
     * Returns hash of object.
     * @return hash of object as a int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, overdraftProtectionLevel, accountType,
                firstName, middleName, lastName, email, password, balance);
    }
}
