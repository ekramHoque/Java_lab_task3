import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("ramin","101",2000));
        accounts.add(new CurrentAccount("karim","102",500));
        accounts.add(new PremiumDepositAccount("abdullah","103",1000));

        boolean run = true;
        while (run){
            System.out.println("Enter your choice");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");

            int choice;
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Which account you want to create?");
                    System.out.println("1. Current Account");
                    System.out.println("2. Savings Account");
                    System.out.println("3. Premium Deposit Account");

                    int chice2 = s.nextInt();

                    System.out.println("Enter Account ID");
                    s.nextLine();
                    String id = s.nextLine();
                    System.out.println("Enter Account Name");
                    String name = s.nextLine();
                    System.out.println("Enter Account Balance");
                    double balance = s.nextDouble();

                    if(chice2 == 1){
                        accounts.add(new CurrentAccount(name,id,balance));
                    }else if(chice2 == 2){
                        accounts.add(new SavingsAccount(name,id,balance));
                    }else if(chice2 == 3){
                        accounts.add(new PremiumDepositAccount(name,id,balance));
                    }else{
                        System.out.println("Wrong choice");
                    }
                    break;

                case 2:
                    System.out.println("Enter Account ID");
                    String checkId ;
                    s.nextLine();
                    checkId = s.nextLine();

                    System.out.println("Enter deposit amount");
                    double amount = s.nextDouble();

                    for(Account a:accounts){
                        if(a.getId().equals(checkId)){
                            a.deposit(amount);
                            System.out.println("Your Current balance " + a.getBalance() );
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Account ID");
                    String checkId2 ;
                    s.nextLine();
                    checkId2 = s.nextLine();

                    System.out.println("Enter withdraw amount");
                    double amount1 = s.nextInt();

                    for(Account a:accounts){
                        if(a.getId().equals(checkId2)){
                            boolean checkWithdraw = a.withdraw(amount1);
                            if(checkWithdraw){
                                System.out.println("Withdrawal Successfully");
                            }else{
                                System.out.println("Withdrawal Failed");
                            }
                            System.out.println("Your Current balance " + a.getBalance() );
                            break;
                        }
                    }
                    break;

                case 4:

                    String selfAccountId,destinationAccountId;
                    System.out.println("Enter Your Account ID");
                    s.nextLine();
                    selfAccountId = s.nextLine();
                    System.out.println("Enter Your Destination Account ID");
                    destinationAccountId = s.nextLine();
                    double transferAmount;
                    System.out.println("Enter your amount to transfer");
                    transferAmount = s.nextDouble();

                    Account fromACC = null,toACC = null;

                    for(Account a:accounts){
                        if(a.getId().equals(selfAccountId)){
                            fromACC = a;
                        }
                        if(a.getId().equals(destinationAccountId)){
                            toACC = a;
                        }
                    }
                    if (fromACC != null && toACC != null) {
                        boolean checkTransfer = fromACC.toTarnsfer(toACC, transferAmount);
                        if(checkTransfer){
                            System.out.println("Transfer Successfully");
                            System.out.println("Your Current balance " + fromACC.getBalance());
                            System.out.println("Destination Current balance " + toACC.getBalance());
                        }else{
                            System.out.println("Transfer Failed");
                        }
                    } else {
                        System.out.println("One or both account IDs are invalid.");
                    }
                    break;

                case 5:
                    for (Account a : accounts) {
                        System.out.println("Name: " + a.name + ", ID: " + a.getId() + ", Balance: " + a.getBalance());
                    }
                    break;

                case 6:
                    run = false;
                    System.out.println("Good Bye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;



            }

        }
        s.close();
    }
}