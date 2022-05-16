package com.kata.katabankaccount.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private double balance;
    private double minBalanceAuthorized = -50;
    private final List<IOperation> listOperations = new ArrayList<>();

    public BankAccount() {}

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(double balance, double minBalanceAuthorized) {
        this.balance = balance;
        this.minBalanceAuthorized = minBalanceAuthorized;
    }

    public void makeDeposit(double amountToSave) {
        IOperation deposit = new Deposit(amountToSave, new Date(), this.balance);
        this.balance = deposit.execute();
        listOperations.add(deposit);
    }

    public void makeWithdrawalWithLimitChecking(double amountToRetrieve) {
        if (this.balance - amountToRetrieve >= getMinBalanceAuthorized()) {
            Operation withdrawal = new Withdrawal(amountToRetrieve, new Date(), this.balance);
            this.balance = withdrawal.execute();
            withdrawal.setAmount(-amountToRetrieve);
            listOperations.add(withdrawal);
        }
    }

    public String printAccountStatement() {
        StringBuilder sb = new StringBuilder("DATE || AMOUNT || BALANCE\n");
        listOperations.forEach(operation -> {
            sb.append(operation.toString());
            sb.append("\n");
        });
        System.out.println(sb);
        return sb.toString();
    }

    public List<IOperation> getListOperations() {
        return listOperations;
    }


    public double getMinBalanceAuthorized() {
        return minBalanceAuthorized;
    }

    public void setMinBalanceAuthorized(double minBalanceAuthorized) {
        this.minBalanceAuthorized = minBalanceAuthorized;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}