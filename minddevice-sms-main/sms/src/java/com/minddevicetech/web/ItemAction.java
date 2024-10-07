package com.minddevicetech.web;

import com.minddevicetech.dao.ItemDao;
import com.minddevicetech.domain.Item;
import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import com.minddevicetech.utility.Utility;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

public class ItemAction extends ActionSupport implements ServletRequestAware, ModelDriven<Item> {

    private Item item = new Item();

    private ItemDao itemDao = null;

    public void setItemDao(ItemDao aItemDao) {
        itemDao = aItemDao;
    }

    private List<Item> itemList = null;

    HttpServletRequest request;

    private String message = null;
    private String jspNameToBeNavigated = null;

    private Utility utility = null;

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public String addItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String processAddItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                item.setCreationDate(new Date());
                item.setStatus("active");
                itemDao.saveItem(item);
                message = "Item added successfully";
                jspNameToBeNavigated = "successItem";
                utility.updateItemListInAppScope();
            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String viewItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String viewAllItems() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                itemList = itemDao.findAllItems("active");

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String editItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                item = itemDao.findItem(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("item", item);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String processEditItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                item.setCreationDate(new Date());
                itemDao.saveItem(item);
                message = "Item Edited successfully";
                jspNameToBeNavigated = "successItem";
                utility.updateItemListInAppScope();
            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String deleteItem() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                item = itemDao.findItem(Integer.parseInt(request.getParameter("id")));
                item.setStatus("deleted");
                itemDao.saveItem(item);
                message = "Item deleted successfully";
                jspNameToBeNavigated = "successItem";
                utility.updateItemListInAppScope();

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public Item getModel() {
        return item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJspNameToBeNavigated() {
        return jspNameToBeNavigated;
    }

    public void setJspNameToBeNavigated(String jspNameToBeNavigated) {
        this.jspNameToBeNavigated = jspNameToBeNavigated;
    }

    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
}
