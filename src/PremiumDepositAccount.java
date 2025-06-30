public class PremiumDepositAccount extends Account {

    int installment = 0;

    PremiumDepositAccount(String name, String userId,double balance) {
        super(name,userId,balance+balance*0.07);
    }

    @Override
    public boolean setTransfer() {
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        balance = balance + amount+interestCalc(amount);
        installment++;
        return true;
    }

    @Override
    public double interestCalc(double amount) {
        return balance*0.07;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount && installment >= 5) {
            balance = balance - amount;
            return true;
        }else{
            return false;
        }
    }
}
