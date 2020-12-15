import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private static int latestAccountNumber = 0;
    private static Bank bank_instance = null;
    private List<ChequingsAccount> chequeingAccountList = new ArrayList<ChequingsAccount>();
    private List<SavingsAccount> savingsAccountList = new ArrayList<SavingsAccount>();
    private Bank() { }
    
    public void addChequingsAccount() {
        latestAccountNumber++;
        ChequingsAccount newChequeingAccount = new ChequingsAccount(latestAccountNumber);
        chequeingAccountList.add(newChequeingAccount);
    }

    public void addSavingsAccount(final InterestRateFrequency interestRateFrequency) {
        latestAccountNumber++;
        SavingsAccount newSavingsAccount = new
                SavingsAccount(latestAccountNumber, interestRateFrequency);
        savingsAccountList.add(newSavingsAccount);
    }

    public static int getLatestAccountNumber() {
        return latestAccountNumber;
    }

    public static void setLatestAccountNumber(final int latestAccountNumber) {
        Bank.latestAccountNumber = latestAccountNumber;
    }

    public List<ChequingsAccount> getChequeingAccountList() {
        return chequeingAccountList;
    }

    public List<SavingsAccount> getSavingsAccountList() {
        return savingsAccountList;
    }
    public static Bank getInstance() {
        if (bank_instance == null) {
            bank_instance = new Bank();
        }
        return bank_instance;
    }

    @Override
    public String toString() {
        return "Bank{"
                + ", chequeingAccountList=" + chequeingAccountList
                + ", savingsAccountList=" + savingsAccountList
                + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(chequeingAccountList, savingsAccountList);
    }
}
