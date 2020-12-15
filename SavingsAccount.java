/**
 * SavingsAccount.
 *
 * @author Eric Dong, Sepehr Mansouri
 * @version 1.0
 */
public class SavingsAccount extends AbstractAccount {
    private static String serviceChargeType;
    private static final AccountType ACCOUNT_TYPE = AccountType.SAVINGS;
    private InterestRateFrequency interestRateFrequency;
    private double serviceCharge;
    private double interestRate;
    /**
     * Constructor.
     *
     * @param accountNumber Number of account.
     * @param interestRateFrequency Interest Rate frequency.
     */
    public SavingsAccount(final int accountNumber,
                          final InterestRateFrequency interestRateFrequency) {
        super(ACCOUNT_TYPE, accountNumber);
        this.interestRateFrequency = interestRateFrequency;
    }
    /**
     * Return serviceChargeType as string.
     * @return ServiceChargeType.
     */
    public static String getServiceChargeType() {
        return serviceChargeType;
    }
    /**
     * Sets serviceChargeType to parameter.
     * @param serviceChargeType New service charge type as string.
     */
    public static void setServiceChargeType(final String serviceChargeType) {
        SavingsAccount.serviceChargeType = serviceChargeType;
    }

    /**
     * returns InterestRate frequency as interestRateFrequency.
     * @return InterestRateFrequency.
     */
    public InterestRateFrequency getInterestRateFrequency() {
        return interestRateFrequency;
    }

    /**
     * Sets interestRateFrequency to new InterestRateFrequency.
     * @param interestRateFrequency InterestRateFrequency.
     */
    public void setInterestRateFrequency(final InterestRateFrequency interestRateFrequency) {
        this.interestRateFrequency = interestRateFrequency;
    }


    @Override
    public double deposit(double amount, DepositType depositType) throws IllegalDepositException {
        return 0;
    }

    /**
     * Withdraw amount of money from balance.
     * @param amount amount to withdraw as double.
     * @return new balance after withdraw as double.
     * @throws BalanceExceedsOverDraftProtectionException If balance < overdraft protection.
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
