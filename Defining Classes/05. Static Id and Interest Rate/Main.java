import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String command = reader.readLine();
        while (!command.equals("End")) {
            switch (command.split(" ")[0]) {
                case "Create":
                    createAccount(accounts);
                    break;
                case "Deposit":
                    deposit(Integer.parseInt(command.split(" ")[1]),Double.parseDouble(command.split(" ")[2]),accounts);
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(command.split(" ")[1]),Integer.parseInt(command.split(" ")[2]),accounts);
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(command.split(" ")[1]));
                    break;
            }

            command = reader.readLine();
        }

    }
    private static void createAccount(HashMap<Integer,BankAccount> accounts){
        BankAccount account = new BankAccount();
        accounts.put(account.getCount(),account);
        System.out.printf("Account %s created%n",account);
    }
    private static void deposit(int id, double amount, HashMap<Integer,BankAccount> accounts){
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }
        else{
            accounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to %s%n",amount,accounts.get(id));
        }
    }
    private static void getInterest(int id, int years, HashMap<Integer,BankAccount> accounts){
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }
        else{
            System.out.printf("%.2f%n",accounts.get(id).getInterestRate(years));
        }
    }
    private static void setInterest(double interest){
        BankAccount.setInterestRate(interest);
    }

}







