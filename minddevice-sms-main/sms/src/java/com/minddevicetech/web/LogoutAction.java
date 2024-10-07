
package com.minddevicetech.web;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;


public class LogoutAction
{
    
    public String logout() throws Exception{

        
       try
        {

        Map session= ActionContext.getContext().getSession();

        session.remove("userr");
        session.remove("billItemsList");

        return "success";
        }
        catch(Exception e)
        {
             System.err.println("ERROR MESSAGE : " + e.getMessage());
             return "error";
        }
    }

}
