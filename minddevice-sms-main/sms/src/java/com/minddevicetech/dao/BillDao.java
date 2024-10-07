
package com.minddevicetech.dao;


import com.minddevicetech.abstract_dao.AbstractDaoAnnotation;
import com.minddevicetech.domain.Bill;
import com.minddevicetech.exception.DataAccessLayerException;
import java.util.Date;
import java.util.List;

public class BillDao{
    
    private AbstractDaoAnnotation abstractDaoAnnotation = null;

    public void setAbstractDaoAnnotation(AbstractDaoAnnotation abstractDaoAnnotation) {
        this.abstractDaoAnnotation = abstractDaoAnnotation;
    }
    
    public Bill findBill(int number) throws DataAccessLayerException {
        return (Bill) abstractDaoAnnotation.find(Bill.class, number);
    }

    public void saveBill(Bill bill) throws DataAccessLayerException {
        abstractDaoAnnotation.saveOrUpdate(bill);
    }

     public List findAllBills(String status) throws DataAccessLayerException {

        return abstractDaoAnnotation.findAll(Bill.class, "status", status);
    }

     public List findBillsBetweenTwoDates(Date fromDate, Date toDate, String status) throws DataAccessLayerException {

        return  abstractDaoAnnotation.findBtwTwoDates(Bill.class, fromDate, toDate, "status", status);
    }

}