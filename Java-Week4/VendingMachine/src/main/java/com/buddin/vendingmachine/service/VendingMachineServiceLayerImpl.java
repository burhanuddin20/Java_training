
package com.buddin.vendingmachine.service;

import com.buddin.vendingmachine.dao.*;
import com.buddin.vendingmachine.dto.Balance;
import com.buddin.vendingmachine.dto.Change;
import com.buddin.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author burhan
 * @date 14 Aug 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao;

    VendingMachineDao dao;
    BalanceDao balanceDao;
    Change changeDao;
    private Object VendingMachineDaoPersistenceException;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao,BalanceDao balanceDao,Change changeDao,VendingMachineAuditDao auditDao){

        this.dao = dao;
        this.balanceDao = balanceDao;
        this.changeDao = changeDao;
        this.auditDao = auditDao;

    }



    @Override
    public List<Item> getAllItems() throws VendingMachineDaoPersistenceException {
        return dao.getAll();
    }

    @Override
    public Item selectItem(int id) throws VendingMachineDaoPersistenceException,VendingMachineNoStockException,VendingMachineInsufficientFundsException {
       if (dao.getItem(id).getStock() == 0){

           throw new VendingMachineNoStockException("Item not available");
       }


       else if (dao.getItem(id).equals(null)){
           throw  new VendingMachineDaoPersistenceException("Item does not exist");
       }
        checkBalance(id);


        return dao.getItem(id);
    }

    @Override
    public void checkBalance(int id) throws VendingMachineDaoPersistenceException, VendingMachineInsufficientFundsException {


        //.compareTo returns -1,0,1 where minus one means the first value is less than the 2nd
        if (dao.getItem(id).getPrice().compareTo(balanceDao.getBalance()) > 0) {

            {
                throw new VendingMachineInsufficientFundsException("Not enough money");
            }

        }
    }





    @Override
    public Item getItem(int id) throws VendingMachineDaoPersistenceException {

        auditDao.writeAuditEntry(("Item" + dao.getItem(id) + "Retrieved"));
        return dao.getItem(id);
    }

    @Override
    public void addItems(int id,Item goods) throws VendingMachineDaoPersistenceException {


        dao.addItem(id,goods);

    }

    // get the user balance
    @Override
    public BigDecimal getUserBalance() throws VendingMachineDaoPersistenceException {

        return balanceDao.getBalance();
    }

    public void getChange (BigDecimal change , BigDecimal itemCost ){
        // get the change in pennies first
        BigDecimal inPennies = change.multiply(new BigDecimal(100));



        for (Change.Coin coin: Change.Coin.values()){
            // for quarters
            switch (coin){

                case DIME:
                    int dimes = ((inPennies.divide(new BigDecimal(10))).intValue());
                    System.out.println("line runs");
                    changeDao.setDime(dimes);
                    // subtract the total value of the quarters from the balance in pennies
                    inPennies = inPennies.subtract(new BigDecimal(changeDao.getDime() * 10));
                    break;
                case QUARTER:
                    // divide by 25 and round down to cloest int
                    changeDao.setQuarter((inPennies.divide(new BigDecimal(25)).setScale(0, RoundingMode.DOWN)).intValue());
                    // subtract the total value of the quarters from the balance in pennies
                    inPennies = inPennies.subtract(new BigDecimal((changeDao.getQuarter()*25)));
                    break;
                case NICKEL:
                    // divide by 5 and round down
                    changeDao.setNickel(((inPennies.divide(new BigDecimal(10)).setScale(0, RoundingMode.DOWN)).intValue()));
                    // subtract the total value of the quarters from the balance in pennies
                    inPennies = inPennies.subtract(new BigDecimal(changeDao.getNickel() * 5));
                    break;

                case PENNY:
                    // Give the remainder in pennies
                    changeDao.setPenny(inPennies.intValue());
                    break;
            }


        }

    }

    //Allows user to add money
    @Override
    public void addBalance(BigDecimal moneyIn) throws VendingMachineDaoPersistenceException {
        balanceDao.adjustBalance(moneyIn);

    }

    @Override
    public Item updateStock(int id) throws VendingMachineDaoPersistenceException {

        int oldStock = dao.getItem(id).getStock();
        dao.updateInventory(id,oldStock -1);

        return dao.getItem(id);

    }

    @Override
    public int returnPennies() throws VendingMachineDaoPersistenceException {
         return changeDao.getPenny();

    }

    @Override
    public int returnNickels() throws VendingMachineDaoPersistenceException {
        return changeDao.getNickel();
    }

    @Override
    public int returnDimes() throws VendingMachineDaoPersistenceException {
        return changeDao.getDime();
    }

    @Override
    public int returnQuarters() throws VendingMachineDaoPersistenceException {
        return  changeDao.getQuarter();
    }


}
