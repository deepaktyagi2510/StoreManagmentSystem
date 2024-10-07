

package com.minddevicetech.dao;


import com.minddevicetech.abstract_dao.AbstractDaoAnnotation;
import com.minddevicetech.domain.Bill;
import com.minddevicetech.domain.Item;
import com.minddevicetech.exception.DataAccessLayerException;
import java.util.List;

public class SearchDao{
    
     private AbstractDaoAnnotation abstractDaoAnnotation = null;

    public void setAbstractDaoAnnotation(AbstractDaoAnnotation abstractDaoAnnotation) {
        this.abstractDaoAnnotation = abstractDaoAnnotation;
    }
    public List searchItems(String itemName, String status) throws DataAccessLayerException {

        return abstractDaoAnnotation.search(Item.class, "name", itemName, "status", status);
        
    }

    public Bill searchBill(int billNumber) throws DataAccessLayerException {

        return (Bill)abstractDaoAnnotation.find(Bill.class, billNumber);

    }

}