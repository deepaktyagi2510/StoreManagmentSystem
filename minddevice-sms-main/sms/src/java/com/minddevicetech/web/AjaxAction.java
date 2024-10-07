package com.minddevicetech.web;

import com.minddevicetech.domain.Item;
import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;

public class AjaxAction extends ActionSupport {

     private int itemId = 0;
     private double itemPrice = 0;


    public String showItemPrice() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Map application = ActionContext.getContext().getApplication();
                List<Item> itemListInAppScope = (List) application.get("itemListInAppScope");

                for (Item item : itemListInAppScope) {

                if(item.getId() == itemId){
                    itemPrice = item.getPrice();
                    break;
                }

            }

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    
}
