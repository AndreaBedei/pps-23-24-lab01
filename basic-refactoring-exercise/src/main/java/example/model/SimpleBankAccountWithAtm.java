package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final int fee;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, int fee) {
        super(holder, balance);
        this.fee = fee;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        super.deposit(userID, amount - fee);

    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount + fee);
    }
}
