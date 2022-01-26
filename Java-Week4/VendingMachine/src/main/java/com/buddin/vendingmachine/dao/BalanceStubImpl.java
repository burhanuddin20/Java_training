package com.buddin.vendingmachine.dao;

import com.buddin.vendingmachine.dto.Balance;
import com.buddin.vendingmachine.dto.Item;

import java.math.BigDecimal;

public class BalanceStubImpl implements BalanceDao{

    public Balance onlyBalance;


    public BalanceStubImpl(){

        onlyBalance = new Balance(new BigDecimal("5.00"));

    }

    public BalanceStubImpl(Balance testBalance){

        this.onlyBalance = testBalance;
    }

    @Override
    public BigDecimal getBalance() throws VendingMachineDaoPersistenceException {


        return onlyBalance.getFunds();



    }

    @Override
    public BigDecimal adjustBalance(BigDecimal moneyIn) throws VendingMachineDaoPersistenceException {
        return null;
    }

    @Override
    public BigDecimal MinusBalance(BigDecimal moneyIn, BigDecimal moneyOut) throws VendingMachineDaoPersistenceException {
        return null;
    }

    /*@Override
    public BigDecimal addToBalance(BigDecimal moneyIn) throws VendingMachineDaoPersistenceException {

        if ((moneyIn.compareTo(onlyBalance.getFunds()) == 0)){

            return onlyBalance.getFunds();
        }

        else {

            return null;
        }

    }
    */

}
