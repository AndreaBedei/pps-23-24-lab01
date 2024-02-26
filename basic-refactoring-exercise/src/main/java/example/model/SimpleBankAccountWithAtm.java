package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public static final int FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int userID, final double amount) {
        super.deposit(userID, amount - FEE);

    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount + FEE);
    }   
}
