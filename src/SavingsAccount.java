public class SavingsAccount extends Account{


    SavingsAccount(String name, String userId,double balance) {
        super(name,userId,balance+balance*0.025);
    }

    @Override
    public boolean setTransfer() {
        return true;
    }

    @Override
    public double interestCalc(double amount) {
        return balance*0.025;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount && (balance - amount) >= 1000) {
            balance = balance - amount;
            return true;
        }else{
            return false;
        }
    }
}
