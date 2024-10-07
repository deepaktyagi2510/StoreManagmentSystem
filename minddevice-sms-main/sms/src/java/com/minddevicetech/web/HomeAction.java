package com.minddevicetech.web;

import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import com.minddevicetech.utility.Utility;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class HomeAction extends ActionSupport {

    private Utility utility = null;

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    @Override
    public String execute() throws Exception {
        String flag = "success";
        try {
            utility.populateItemListInAppScope();
            Map session = ActionContext.getContext().getSession();
            Userr userr = (Userr) session.get("userr");

            if (userr != null) {

            } else {
                flag = "notLoggedIn";

            }
        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            e.printStackTrace();
            flag = "error";

        }
        return flag;
    }

}
