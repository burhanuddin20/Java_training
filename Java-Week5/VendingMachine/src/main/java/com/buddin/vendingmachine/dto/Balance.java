package com.buddin.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

// hold the amount of money in the system
public class Balance {

    BigDecimal funds;

    public Balance(BigDecimal funds){

        this.funds = funds;
    }

    // getter to get the amount of money in the machine
    public BigDecimal getFunds() {
        return funds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(funds, balance.funds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funds);
    }
}

