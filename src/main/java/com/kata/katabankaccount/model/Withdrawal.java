package com.kata.katabankaccount.model;

import java.util.Date;

public class Withdrawal extends Operation {

    public Withdrawal(double amount, Date date, double accountBalance) {
        super(amount, date, accountBalance);
    }
    @Override
    public double execute() {
        setAccountBalance(getAccountBalance() - getAmount());
        return getAccountBalance();
    }
}