/**
 * Object of chequing Account.
 *
 * @author Eric Dong, Sepehr Mansouri
 * @version 1.0
 */
public class ChequingsAccount extends AbstractAccount {

    private static final AccountType ACCOUNT_TYPE = AccountType.CHEQUINGS;
    private String serviceChargeType;
    private double serviceCharge;

    /**
     * Constructor.
     * @param accountNumber Account number as int.
     */
    public ChequingsAccount(final int accountNumber) {
        super(ACCOUNT_TYPE, accountNumber);
    }

    /**
     * Adds deposit to balance.
     * @param amount Deposit amount Amount to deposit.
     * @param depositType Deposit type.
     * @return New balance as double.
     * @throws IllegalDepositException Thrown if deposit type is not allowed.
     */
    @Override
    public double deposit(final double amount, final DepositType depositType)
            throws IllegalDepositException {
        if (!isDepositTypeValid(depositType)) {
            throw new IllegalDepositException(
                    "Deposit type is not valid, must be Cheque, Cash, Or E_Transfer");
        }
        setBalance(getBalance() + amount - serviceCharge);
        return getBalance();
    }

    /**
     * Withdraws amount from balance.
     * @param amount amount to withdraw as double.
     * @return New balance.
     * @throws BalanceExceedsOverDraftProtectionException if new balance is less than overdraft.
     */
    @Override
    public double withdraw(final double amount) throws BalanceExceedsOverDraftProtectionException {
        double newBalance = getBalance() - amount - serviceCharge;
        if (-1 * getOverdraftProtectionAmount() > newBalance) {
            throw new BalanceExceedsOverDraftProtectionException(
                    "Balance would exceed overDraftProtectionLimit");
        }
        setBalance(newBalance);
        return getBalance();
    }
}
