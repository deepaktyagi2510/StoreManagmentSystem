
package com.minddevicetech.web;

import com.opensymphony.xwork2.ActionSupport;


public class SuccessMsgAction extends ActionSupport
{

    private String message = null;
    private String jspNameToBeNavigated = null;
    private int billNoToShowInvoice = 0;

    public String success() throws Exception{

         return jspNameToBeNavigated;
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

    public int getBillNoToShowInvoice() {
        return billNoToShowInvoice;
    }

    public void setBillNoToShowInvoice(int billNoToShowInvoice) {
        this.billNoToShowInvoice = billNoToShowInvoice;
    }

    
   

}
