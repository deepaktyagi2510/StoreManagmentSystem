package com.minddevicetech.web;

import com.minddevicetech.dao.BillDao;
import com.minddevicetech.dao.BillItemDao;
import com.minddevicetech.dao.SearchDao;
import com.minddevicetech.domain.Bill;
import com.minddevicetech.domain.BillItem;
import com.minddevicetech.domain.Item;
import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import com.minddevicetech.utility.Utility;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

public class SearchAction extends ActionSupport implements ServletRequestAware {

    private int itemId = 0;
    private String itemName = null;
    private int billNumber = 0;

    private double totalAmount = 0;

    private Date fromDate = null;
    private Date toDate = null;

    private List<Item> itemList = null;
    private List<BillItem> billItemsList = null;
    private List<Bill> billList = null;

    HttpServletRequest request;

    private SearchDao searchDao = null;

    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    private BillDao billDao = null;

    public void setBillDao(BillDao aBillDao) {
        billDao = aBillDao;
    }

    private BillItemDao billItemDao = null;

    public void setBillItemDao(BillItemDao aBillItemDao) {
        billItemDao = aBillItemDao;
    }

    private String searchHeadingText = null;

    private Utility utility = null;

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public String search() throws Exception {
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

    public String todaysSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Date today = new Date();
                billList = billDao.findBillsBetweenTwoDates(today, today, "active");

                calculateTotalAmount(billList);

                searchHeadingText = "Today's Sale";

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String lastSevenDaysSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Date fromDate = utility.findDateBefore(7);
                Date toDate = new Date();
                billList = billDao.findBillsBetweenTwoDates(fromDate, toDate, "active");
                calculateTotalAmount(billList);
                searchHeadingText = "Last 7 Days Sale";

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String lastThirtyDaysSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Date fromDate = utility.findDateBefore(30);
                Date toDate = new Date();
                billList = billDao.findBillsBetweenTwoDates(fromDate, toDate, "active");
                calculateTotalAmount(billList);
                searchHeadingText = "Last 30 Days Sale";

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String betweenTwoDatesSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                billList = billDao.findBillsBetweenTwoDates(fromDate, toDate, "active");

                calculateTotalAmount(billList);

//                searchHeadingText = "Sale Between Dates ("+fromDate.getMonth()+"/"+fromDate.getDay()+"/"+fromDate.getYear()
//                        +" - "
//                        +toDate.getMonth()+"/"+toDate.getDay()+"/"+toDate.getYear()+")";
                searchHeadingText = "Sale Between Two Dates";

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String viewCanceledBillsOwner() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                billList = billDao.findAllBills("canceled");

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String itemWiseSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Map application = ActionContext.getContext().getApplication();
                if (application.get("itemListInAppScope") == null) {
                    utility.populateItemListInAppScope();
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

    public String viewItemWiseSell() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                billItemsList = billItemDao.findAllBillItemsByItemId(itemId);

                for (BillItem billItem : billItemsList) {

                    totalAmount = totalAmount + (billItem.getItemPrice() * billItem.getItemQuantity());

                }

                itemName = utility.getItemName(itemId);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String searchItem() throws Exception {
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

    public String processSearchItem() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                itemList = searchDao.searchItems(itemName, "active");

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String searchBill() throws Exception {
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

    public String processSearchBill() throws Exception {
        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                Bill searchedBill = searchDao.searchBill(billNumber);
                request.setAttribute("searchedBill", searchedBill);
                billItemsList = billItemDao.findABillItems(billNumber);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public List<BillItem> getBillItemsList() {
        return billItemsList;
    }

    public void setBillItemsList(List<BillItem> billItemsList) {
        this.billItemsList = billItemsList;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void calculateTotalAmount(List<Bill> billList) {

        for (Bill bill : billList) {

            totalAmount = totalAmount + bill.getTotalAmount();

        }

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getSearchHeadingText() {
        return searchHeadingText;
    }

    public void setSearchHeadingText(String searchHeadingText) {
        this.searchHeadingText = searchHeadingText;
    }

}
