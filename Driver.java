import java.util.Scanner;

public class Driver {



    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Scanner accountType = new Scanner(System.in);
        Scanner interestFreq = new Scanner(System.in);
        int entry = accountType.nextInt();
        System.out.println("Please Enter 1, 2, 3 to create a new Chequings, Savings or Childrens Account" +
                    "Press 0 to quit");
        while (entry != 0) {
            if (entry == 1) {
                bank.addChequingsAccount();
            } else if (entry == 2) {
                System.out.println("What is the interest Rate frequency for your Savings account?");
            }
        }
        }


}