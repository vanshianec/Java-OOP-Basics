public class BankAccount {
    private static int idCount=0;
    private double balance;
    private static final double DEFAUlT_INEREST=0.02;
    private static double interestRate=DEFAUlT_INEREST;
    private int id;


    public BankAccount(){
        id=++idCount;
    }
    public int getCount(){
        return idCount;
    }


    public static void setInterestRate(double interest){
     interestRate=interest;
    }
    public double getInterestRate(int years){
        return balance*interestRate*years;
    }
    public void deposit(double amount){
        balance+=amount;
    }
    public String toString(){
        return String.format("ID%d",id);
    }




}
