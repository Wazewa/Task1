package academy.mediasoft.team;

public class Main {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount("Вася");
        BankAccount ba2 = new BankAccount("Семен");
        System.out.println(ba1.deposit(1499));
        System.out.println(ba1.transfer(ba2,1499));
    }
}
