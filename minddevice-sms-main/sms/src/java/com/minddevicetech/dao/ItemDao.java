

package com.minddevicetech.dao;


import com.minddevicetech.abstract_dao.AbstractDaoAnnotation;
import com.minddevicetech.domain.Item;
import com.minddevicetech.exception.DataAccessLayerException;
import java.util.List;

public class ItemDao{
    
     private AbstractDaoAnnotation abstractDaoAnnotation = null;

    public void setAbstractDaoAnnotation(AbstractDaoAnnotation abstractDaoAnnotation) {
        this.abstractDaoAnnotation = abstractDaoAnnotation;
    }
    public Item findItem(int id) throws DataAccessLayerException {
        return (Item) abstractDaoAnnotation.find(Item.class, id);
    }

    public void saveItem(Item item) throws DataAccessLayerException {
        abstractDaoAnnotation.saveOrUpdate(item);
    }

    public List findAllItems(String status) throws DataAccessLayerException {

        return abstractDaoAnnotation.findAll(Item.class, "status", status);
    }

}