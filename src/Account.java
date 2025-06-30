public abstract class Account {

    protected  String name;
    protected double balance;
    protected String userId;

    Account(String name, String userId,double balance) {
        this.name = name;
        this.userId = userId;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    String getId() {
        return userId;
    }

    boolean toTarnsfer( Account destination, double amount) {
        if(this.setTransfer() && this.withdraw(amount)) {
            return destination.deposit(amount);
        }else{
            return  false;
        }

    }

    boolean deposit(double amount) {
        balance = balance + amount+interestCalc(amount);
        return true;
    }

    public abstract boolean withdraw(double amount);
    public abstract double interestCalc(double amount);
    public abstract boolean setTransfer();

}
