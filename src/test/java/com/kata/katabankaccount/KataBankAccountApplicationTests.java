package com.kata.katabankaccount;

import com.kata.katabankaccount.model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KataBankAccountApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void depositMoney() {
        BankAccount account = new BankAccount(20);
        account.makeDeposit(100);
        Assertions.assertEquals(120, account.getBalance());
    }

    @Test
    void retrieveMoneyWithSufficientBalance() {
        BankAccount account = new BankAccount(100, -70);
        account.makeWithdrawalWithLimitChecking(130);
        Assertions.assertEquals(-30, account.getBalance());
    }

    @Test
    void retrieveMoneyWithInsufficientBalance() {
        BankAccount account = new BankAccount();
        account.setBalance(50);
        account.setMinBalanceAuthorized(-80);
        account.makeWithdrawalWithLimitChecking(200);
        Assertions.assertEquals(50, account.getBalance());
    }

    @Test
    void printAllOperations() {
        BankAccount account = new BankAccount(15, 0);

        account.makeDeposit(100);
        account.makeWithdrawalWithLimitChecking(150);
        account.makeDeposit(50);
        account.makeWithdrawalWithLimitChecking(100);

        account.printAccountStatement();
        Assertions.assertEquals(3, account.getListOperations().size());
        Assertions.assertEquals(65, account.getBalance());
    }

}
