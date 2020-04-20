package be.uantwerpen.lab3DistSystZsombor.database;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import be.uantwerpen.lab3DistSystZsombor.model.*;

public class BankRepository {

    private static BankRepository instance;

    private List<Account> accounts;

    @PostConstruct
    public static BankRepository getInstance() {
        if (instance == null) {
            instance = new BankRepository();
        }
        return instance;
    }

    public BankRepository() {
        accounts= Arrays.asList(
            new Account(1, "Stef"),
            new Account(2, "Zsombor"),
            new Account(3, "Jaime"),
            new Account(4, "Brecht"),
            new Account(5, "Bartu")
            );
    }

    /**
     * @return the accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * @return the updated account
     */
    public Account updateAccount(int id, int amount) {
        Account temp = accounts.get(id-1);
        temp.setBalance(temp.getBalance() + amount);
        accounts.set(id-1, temp);
        return accounts.get(id-1);
    }
}