
package com.minddevicetech.dao;


import com.minddevicetech.abstract_dao.AbstractDaoAnnotation;
import com.minddevicetech.domain.Userr;
import com.minddevicetech.exception.DataAccessLayerException;

public class UserrDao{
    
     private AbstractDaoAnnotation abstractDaoAnnotation = null;

    public void setAbstractDaoAnnotation(AbstractDaoAnnotation abstractDaoAnnotation) {
        this.abstractDaoAnnotation = abstractDaoAnnotation;
    }
    public Userr findUser(String userName) throws DataAccessLayerException {
        return (Userr) abstractDaoAnnotation.find(Userr.class, userName);
    }

}