
package com.minddevicetech.dao;


import com.minddevicetech.abstract_dao.AbstractDaoAnnotation;
import com.minddevicetech.domain.BillItem;
import com.minddevicetech.exception.DataAccessLayerException;
import java.util.List;

public class BillItemDao{
    
     private AbstractDaoAnnotation abstractDaoAnnotation = null;

    public void setAbstractDaoAnnotation(AbstractDaoAnnotation abstractDaoAnnotation) {
        this.abstractDaoAnnotation = abstractDaoAnnotation;
    }
    
    public List findABillItems(int billNumber) throws DataAccessLayerException {

        return abstractDaoAnnotation.findAll(BillItem.class, "billNumber", billNumber);
    }

    public List findAllBillItemsByItemId(int itemId) throws DataAccessLayerException {

        return abstractDaoAnnotation.findAll(BillItem.class, "itemId", itemId);
    }

    public void saveBillItem(BillItem billItem) throws DataAccessLayerException {
        abstractDaoAnnotation.saveOrUpdate(billItem);
    }

}