package com.minddevicetech.utility;

import com.minddevicetech.dao.ItemDao;
import com.minddevicetech.domain.Item;
import com.opensymphony.xwork2.ActionContext;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utility {
    
    private ItemDao itemDao = null;
    
     public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void populateItemListInAppScope() throws Exception {

        Map application = ActionContext.getContext().getApplication();
        List<Item> itemListInAppScope = (List) application.get("itemListInAppScope");

        if (itemListInAppScope == null) {
            itemListInAppScope = itemDao.findAllItems("active");
            application.put("itemListInAppScope", itemListInAppScope);
            populateItemNameList();
        }

    }

    public void updateItemListInAppScope() throws Exception {

        Map application = ActionContext.getContext().getApplication();
        application.remove("itemListInAppScope");
        application.remove("itemNameHashMap");
        populateItemListInAppScope();

    }

    public void populateItemNameList() throws Exception {

        Map application = ActionContext.getContext().getApplication();
        LinkedHashMap itemNameHashMap = (LinkedHashMap) application.get("itemNameHashMap");

        if (itemNameHashMap == null) {
            itemNameHashMap = new LinkedHashMap();
            List<Item> itemList = (List) application.get("itemListInAppScope");
            for (Item item : itemList) {

                itemNameHashMap.put(item.getId(), item.getName());

            }
            application.put("itemNameHashMap", itemNameHashMap);

        }
    }


    public String getItemName(int itemId) throws Exception {

        Map application = ActionContext.getContext().getApplication();
        LinkedHashMap itemNameHashMap = (LinkedHashMap) application.get("itemNameHashMap");

        if(itemNameHashMap == null)populateItemListInAppScope();

        return (String)itemNameHashMap.get(itemId);
        
    }

    public Date findDateBefore(int days) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -days);
        Date dateBefore = cal.getTime();

        return dateBefore;
    }

   
}
