/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minddevicetech.abstract_dao;

import com.minddevicetech.exception.DataAccessLayerException;
import java.util.Date;
import org.hibernate.HibernateException;

import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AbstractDaoAnnotation {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public AbstractDaoAnnotation() {

    }

    @Transactional
    public void saveOrUpdate(Object obj) throws DataAccessLayerException {
        try {

            template.saveOrUpdate(obj);

        } catch (HibernateException e) {

            handleException(e);
        } finally {

        }
    }

    @Transactional
    public void delete(Object obj) throws DataAccessLayerException {
        try {

            template.delete(obj);

        } catch (HibernateException e) {
            handleException(e);
        } finally {
            // 
        }
    }

    public Object find(Class clazz, int id) throws DataAccessLayerException {
        Object obj = null;
        try {

            obj = template.get(clazz, id);

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return obj;
    }

    public Object find1(Class clazz, int id) throws DataAccessLayerException {
        Object obj = null;
        try {

            obj = template.get(clazz, id);

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return obj;
    }

    public Object find(Class clazz, String id) throws DataAccessLayerException {
        Object obj = null;
        try {

            obj = template.get(clazz, id);

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return obj;
    }

    public List findAll(Class clazz) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where status like 'Active'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }

        return objects;

    }

    public List findByName(Class clazz, String name) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where partyName like '%" + name + "%'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List findAll(Class clazz, String propertyName, String propertyValue) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where " + propertyName + " like '" + propertyValue + "'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List findAll(Class clazz, String propertyName, int propertyValue) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where " + propertyName + " like '%" + propertyValue + "%'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List findAll(Class clazz, String propertyNameOne, String propertyValueOne, String propertyNameTwo, String propertyValueTwo) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where " + propertyNameOne + " like '" + propertyValueOne + "' and " + propertyNameTwo + " like '" + propertyValueTwo + "'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List search(Class clazz, String propertyNameOne, String propertyValueOne, String propertyNameTwo, String propertyValueTwo) throws DataAccessLayerException {
        List objects = null;
        try {

            objects = template.find("from " + clazz.getName() + " where " + propertyNameOne + " like '%" + propertyValueOne + "%' and " + propertyNameTwo + " like '%" + propertyValueTwo + "%'");

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List findBtwTwoDates(Class clazz, Date fromDate, Date toDate) throws DataAccessLayerException {
        List objects = null;
        try {

            String[] paramNames = {"start", "end"};
            Object[] values = {fromDate, toDate};
            objects = template.findByNamedParam("from " + clazz.getName() + "where billDate between :start and :end ", paramNames, values);

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public List findBtwTwoDates(Class clazz, Date fromDate, Date toDate, String propertyName, String propertyValue) throws DataAccessLayerException {
        List objects = null;
        try {

            String[] paramNames = {"start", "end"};
            Object[] values = {fromDate, toDate};
            objects = template.findByNamedParam("from " + clazz.getName() + " where " + propertyName + " like '" + propertyValue + "' and billDate between :start and :end ", paramNames, values);

        } catch (HibernateException e) {
            handleException(e);
        } finally {

        }
        return objects;
    }

    public void handleException(HibernateException e) throws DataAccessLayerException {
        throw new DataAccessLayerException(e);
    }

}
