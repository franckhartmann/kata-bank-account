package com.kata.katabankaccount.model;

import java.util.Date;

public class Deposit extends Operation {

    public Deposit (double amount, Date date, double accountBalance) {
        super(amount, date, accountBalance);
    }
    @Override
    public double execute() {
        setAccountBalance(getAccountBalance() + getAmount());
        return getAccountBalance();
    }
}