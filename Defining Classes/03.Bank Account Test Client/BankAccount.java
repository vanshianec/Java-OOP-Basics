public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        double oldBalance=balance;
        if(oldBalance-amount<0){
            System.out.println("Insufficient balance");
        }
        else{
            balance-=amount;
        }
    }
    public String toString(){
        return String.format("Account ID%d, balance %.2f",id,balance);
    }


}
