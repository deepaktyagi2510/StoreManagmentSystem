package com.minddevicetech.web;

import com.minddevicetech.dao.BillDao;
import com.minddevicetech.dao.BillItemDao;
import com.minddevicetech.domain.Bill;
import com.minddevicetech.domain.BillItem;
import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import com.minddevicetech.utility.Utility;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

public class BillAction extends ActionSupport implements ServletRequestAware {

    private BillDao billDao = null;

    public void setBillDao(BillDao aBillDao) {
        billDao = aBillDao;
    }

    private BillItemDao billItemDao = null;

    public void setBillItemDao(BillItemDao aBillItemDao) {
        billItemDao = aBillItemDao;
    }

    private int itemId = 0;
    private double itemPrice = 0;
    private double itemQuantity = 0;

    HttpServletRequest request;

    private List<Bill> billList = null;
    private List<BillItem> billItemsList = null;

    private String message = null;
    private String jspNameToBeNavigated = null;
    private int billNoToShowInvoice = 0;

    private Utility utility = null;

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public String createBill() throws Exception {

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

    public String processCreateBill() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                billItemsList = (List) session.get("billItemsList");
                Bill bill = new Bill();
                bill.setBillDate(new Date());
                bill.setStatus("active");
                double totalAmount = 0;
                for (BillItem billItem : billItemsList) {

                    totalAmount = totalAmount + (billItem.getItemPrice() * billItem.getItemQuantity());

                }
                bill.setTotalAmount(totalAmount);
                billDao.saveBill(bill);

                for (BillItem billItem : billItemsList) {

                    billItem.setBillNumber(bill.getNumber());
                    billItem.setItemDate(new Date());
                    billItemDao.saveBillItem(billItem);

                }
                session.remove("billItemsList");
                message = "Bill created successfully";
                jspNameToBeNavigated = "successBill";
                billNoToShowInvoice = bill.getNumber();

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String addItemInBill() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {
                if (session.get("billItemsList") == null) {
                    billItemsList = new ArrayList();
                    session.put("billItemsList", billItemsList);
                } else {
                    billItemsList = (List) session.get("billItemsList");
                }

                BillItem billItem = new BillItem();
                billItem.setItemId(itemId);
                billItem.setItemName(utility.getItemName(itemId));
                billItem.setItemPrice(itemPrice);
                billItem.setItemQuantity(itemQuantity);

                billItemsList.add(billItem);
                session.put("billItemsList", billItemsList);
                double totalAmountOfBill = 0;
                for (BillItem billItemTemp : billItemsList) {

                    totalAmountOfBill = totalAmountOfBill + (billItemTemp.getItemPrice() * billItemTemp.getItemQuantity());

                }
                session.put("totalAmountOfBill", totalAmountOfBill);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String deleteItemFromBill() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {
                billItemsList = (List) session.get("billItemsList");
                int id = Integer.parseInt(request.getParameter("id"));

                billItemsList.remove(id);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";
        }
        return flag;
    }

    public String viewBill() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                Bill bill = billDao.findBill(id);
                request.setAttribute("bill", bill);
                billItemsList = billItemDao.findABillItems(id);

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String viewAllBills() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                billList = billDao.findAllBills("active");

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = "error";

        }
        return flag;
    }

    public String viewCanceledBills() throws Exception {

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

    public String cancelBill() throws Exception {

        String flag = "success";
        try {
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                Bill billTemp = billDao.findBill(id);
                billTemp.setStatus("canceled");
                billDao.saveBill(billTemp);
                message = "Bill canceled successfully";
                jspNameToBeNavigated = "successBill";

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

    public double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public List<BillItem> getBillItemsList() {
        return billItemsList;
    }

    public void setBillItemsList(List<BillItem> billItemsList) {
        this.billItemsList = billItemsList;
    }

    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
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

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public int getBillNoToShowInvoice() {
        return billNoToShowInvoice;
    }

    public void setBillNoToShowInvoice(int billNoToShowInvoice) {
        this.billNoToShowInvoice = billNoToShowInvoice;
    }
}
