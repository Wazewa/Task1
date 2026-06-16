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
        if(isValidAmount(amount)) {
            balance += amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(int amount) {
        if(isValidAmount(amount) && isBalanceHasEnoughFunds(amount)) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean transfer(BankAccount otherAccount, int amount){
        if(canMakeTransfer(otherAccount, amount)) {
            if(otherAccount.deposit(amount)) {
                withdraw(amount);
                return true;
            }
        }
        return false;
    }
    private boolean isValidAmount(int amount) {
        return amount > 0;
    }
    private boolean isAccountExists(BankAccount otherAccount) {
        return otherAccount != null;
    }
    private boolean isBalanceHasEnoughFunds(int amount) {
        return balance >= amount;
    }
    private boolean canMakeTransfer(BankAccount otherAccount, int amount) {
        return isValidAmount(amount) && isAccountExists(otherAccount) && isBalanceHasEnoughFunds(amount);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ИНФОРМАЦИЯ О ВЛАДЕЛЬЦЕ СЧЕТА\n\tИмя владельца: ");
        sb.append(nameOwner);
        sb.append("\n\t");
        sb.append("Текущий баланс: ");
        sb.append(balance);
        sb.append("\n\t");
        sb.append("Дата создания счета: ");
        sb.append(createdDate);
        sb.append("\n\t");
        sb.append("Счет заблокирован? ");
        sb.append(isBlocked);
        sb.append("\n");

        return sb.toString();
    }
}
