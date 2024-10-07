package com.minddevicetech.web;

import com.opensymphony.xwork2.ActionSupport;
import com.minddevicetech.domain.Userr;
import com.opensymphony.xwork2.ActionContext;
import com.minddevicetech.dao.UserrDao;

public class LoginAction extends ActionSupport {

    private String userName = null;
    private String password = null;

    private UserrDao userrDao = null;

    public void setUserrDao(UserrDao userrDao) {
        this.userrDao = userrDao;
    }

    public String login() throws Exception {
        String flag = SUCCESS;

        try {

            Userr userr = (Userr) userrDao.findUser(userName);

            if (userr != null) {
                if (userr.getPassword().equals(password)) {
                    ActionContext.getContext().getSession().put("userr", userr);
                } else {
                    addFieldError("password", "Wrong Password");
                    flag = INPUT;
                }
            } else {
                addFieldError("userName", "Enter Valid User Id");
                flag = INPUT;
            }

        } catch (Exception e) {
            System.err.println("ERROR MESSAGE : " + e.getMessage());
            flag = ERROR;
        }
        return flag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
