package academy.mediasoft.team;

import java.time.LocalDateTime;

public class BankAccount {
    private String nameOwner;
    private int balance;
    private LocalDateTime createdDate;
    private boolean isBlocked;

    public BankAccount(String nameOwner) {
        this.nameOwner = nameOwner;
        balance = 0;
        createdDate = LocalDateTime.now();
        isBlocked = false;
    }
    public boolean deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(int amount) {
        if(balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean transfer(BankAccount otherAccount, int amount){
        if(amount > 0 && otherAccount != null && balance >= amount) {
             withdraw(amount);
             otherAccount.deposit(amount);
             return true;
        }
        return false;
    }
}
