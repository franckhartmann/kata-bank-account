package com.kata.katabankaccount.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Operation implements IOperation {

    private double amount;
    private Date date;
    private double accountBalance;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    protected Operation(double amount, Date date, double accountBalance) {
        this.amount = amount;
        this.date = date;
        this.accountBalance = accountBalance;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return sdf.format(date) + " || "
                + amount + "|| "
                + accountBalance;
    }
}