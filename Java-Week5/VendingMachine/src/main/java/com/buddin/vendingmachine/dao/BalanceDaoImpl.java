package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.dto.Balance;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class BalanceDaoImpl implements BalanceDao{

    private BigDecimal balance;
    @Override
    public BigDecimal getBalance() throws VendingMachineDaoPersistenceException {
        return balance;
    }

    @Override
    public BigDecimal adjustBalance(BigDecimal moneyIn) throws VendingMachineDaoPersistenceException {
        Balance newBalance = new Balance(moneyIn);
        balance = newBalance.getFunds();
        return  newBalance.getFunds();

    }
    @Override
    public BigDecimal MinusBalance(BigDecimal moneyIn, BigDecimal moneyOut) throws VendingMachineDaoPersistenceException {
        Balance newBalance = new Balance(moneyIn);
        balance = newBalance.getFunds().subtract(moneyOut);
        return  balance;

    }
}
