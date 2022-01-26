package com.buddin.vendingmachine.dao;

import java.math.BigDecimal;

public interface BalanceDao {

    // returns the amount of money in machine

    BigDecimal getBalance() throws VendingMachineDaoPersistenceException;

    // add money to the machine

    BigDecimal adjustBalance (BigDecimal moneyIn) throws VendingMachineDaoPersistenceException;

    BigDecimal MinusBalance(BigDecimal moneyIn, BigDecimal moneyOut) throws VendingMachineDaoPersistenceException;
}
