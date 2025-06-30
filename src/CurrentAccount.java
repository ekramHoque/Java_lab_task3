public class CurrentAccount extends Account {


    CurrentAccount(String name, String userId,double balance) {
        super(name,userId,balance+balance*0.0);
    }

    @Override
    public boolean setTransfer() {
        return true;
    }

    @Override
    public double interestCalc(double amount) {
        return balance * 0.0;
    }

    @Override
    public boolean withdraw(double amount) {

        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }else{
            return false;
        }

    }
}
