package com.buddin.vendingmachine.dto;


import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class Change {
    private int penny;
    private int nickel;
    private int quarter;
    private int dime;

    // constructor if field left empty
    public Change(){

        this.penny = 0;
        this.nickel = 0;
        this.quarter= 0;
        this.dime = 0;
    }

    // if each value is given then use this constructor


    // Enum that holds each coin type
    public enum Coin{
        QUARTER,DIME,NICKEL,PENNY
    }


    // setters and getters for each coin type
    public int getPenny() {
        return penny;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    public int getNickel() {
        return nickel;
    }

    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getDime() {
        return dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Change change = (Change) o;
        return Objects.equals(penny, change.penny) && Objects.equals(nickel, change.nickel) && Objects.equals(quarter, change.quarter) && Objects.equals(dime, change.dime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(penny, nickel, quarter, dime);
    }
}
