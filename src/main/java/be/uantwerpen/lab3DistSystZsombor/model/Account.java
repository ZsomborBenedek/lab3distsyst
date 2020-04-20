package be.uantwerpen.lab3DistSystZsombor.model;

public class Account {

    private final int id;
    private int balance;
    private String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
        if(this.balance < 0) {
            this.balance = 0;
        }
    }
}