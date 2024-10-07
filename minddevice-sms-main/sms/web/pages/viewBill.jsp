

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="common_import.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@ include file="common_include.jsp" %>
        <style type="text/css" media="print">.printbutton {visibility: hidden; display: none;}</style>
    </head>
    <body>
        <div  id="wrapper">
            <div id="header"><%@ include file="header.jsp" %></div>
            <div id="menu"><%@ include file="menu.jsp" %></div>
            <div id="content">
                 <div id="side_navigation"><h1>Billing</h1>

                                <p align="center"><s:url var="url" action="createBill"></s:url><s:a href="%{url}">New Bill</s:a></p>
                                <p align="center"><s:url var="url" action="viewAllBills"></s:url><s:a href="%{url}">View All Bills</s:a></p>
                                <p align="center"><s:url var="url" action="searchBill"></s:url><s:a href="%{url}">Search a Bill</s:a></p>
                                <p align="center"><s:url var="url" action="viewCanceledBills"></s:url><s:a href="%{url}">View Canceled Bills</s:a></p>

                            </div>

    <div align="center" id="main_content">
        <h1 align="center">Invoice</h1>
        <table width="100%">
            <tr><td>
                    <table align="right" width="30%" border="0" style="margin:0 0 10px 0;"><tr>
                <td align="left">Bill No.</td><td>:</td><td align="right"><s:property value="#request.bill.number"></s:property> &nbsp;</td></tr>
            <tr> <td align="left">Dated</td><td>:</td><td align="right"><s:property value="#request.bill.billDate"></s:property> &nbsp;</td></tr>
            <tr> <td align="left">Status</td><td>:</td><td align="right"><s:property value="#request.bill.status"></s:property> &nbsp;</td>
            </tr></table>
                </td></tr>
            <tr><td>
                    <s:if test="billItemsList.size() > 0">
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="5%">S. No</th>
              <th  align="center" width="40%">Items Name</th>
              <th  align="center" width="8%">Price</th>
              <th  align="center" width="8%">Quantity</th>
              <th  align="center" width="8%">Amount</th>
          </tr>
          <s:iterator value="billItemsList" status="id">
          <tr bgcolor="#e1e2f5">
               
               <td align="center" width="5%"><s:property value="%{#id.index+1}" /></td>
               <td align="left" width="40%">&nbsp;<s:property value="itemName" /></td>
               <td align="right" width="8%"><s:property value="itemPrice" />&nbsp;</td>
               <td align="right" width="8%" ><s:property value="itemQuantity" />&nbsp;</td>
               <td align="right" width="8%" ><s:property value="itemPrice*itemQuantity" />&nbsp;</td>

          </tr>
          </s:iterator>
          <tr><td align="right"></td>
              <td colspan="3" align="right">Total of bill</td><td align="right"><s:property value="#request.bill.totalAmount"></s:property>&nbsp;</td></tr>
                   
      </table>
                    </s:if>
                </td></tr>
        </table>
        
        
   </div>
            <table width="100%"><tr><td><script>document.write("<input type='button' onClick='javascript:printInvoice();' class='printbutton' value='Print Invoice'/>");</script></td></tr></table>
            
            </div>
            <div class="clear"></div><br/>
             <div style="height:100px;">&nbsp;</div>
<div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
        <iframe name=print_frame width=0 height=0 frameborder=0 src=about:blank></iframe>
    </body>
</html>
