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
                    createAccount(Integer.parseInt(command.split(" ")[1]),accounts);
                    break;
                case "Deposit":
                    deposit(Integer.parseInt(command.split(" ")[1]),Integer.parseInt(command.split(" ")[2]),accounts);
                    break;
                case "Withdraw":
                    withdraw(Integer.parseInt(command.split(" ")[1]),Integer.parseInt(command.split(" ")[2]),accounts);
                    break;
                case "Print":
                    print(Integer.parseInt(command.split(" ")[1]),accounts);
                    break;
            }

            command = reader.readLine();
        }

    }
    private static void createAccount(int id,HashMap<Integer,BankAccount> accounts){
        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        }
        else{
            accounts.put(id,new BankAccount());
            accounts.get(id).setId(id);
        }
    }
    private static void deposit(int id, int ammount, HashMap<Integer,BankAccount> accounts){
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }
        else{
            accounts.get(id).deposit(ammount);
        }
    }
    private static void withdraw(int id, int ammount, HashMap<Integer,BankAccount> accounts){
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }
        else{
            accounts.get(id).withdraw(ammount);
        }
    }
    private static void print(int id,HashMap<Integer,BankAccount> accounts){
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }
        else{
            System.out.println(accounts.get(id));
        }
    }

}







