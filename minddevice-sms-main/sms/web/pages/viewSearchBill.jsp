

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
                 <div id="side_navigation"><h1>Search</h1>

                              <p align="center"><s:url var="url" action="todaysSell"></s:url><s:a href="%{url}">Today's Sale</s:a></p>
                                <p align="center"><s:url var="url" action="lastSevenDaysSell"></s:url><s:a href="%{url}">Last Seven Days Sale</s:a></p>
                                <p align="center"><s:url var="url" action="lastThirtyDaysSell"></s:url><s:a href="%{url}">Last Thirty Days Sale</s:a></p>
                                <p align="center"><s:url var="url" action="search"></s:url><s:a href="%{url}">Between Two Dates Sale</s:a></p>
                                <p align="center"><s:url var="url" action="itemWiseSell"></s:url><s:a href="%{url}">Item Wise Sale</s:a></p>
                                <p align="center"><s:url var="url" action="viewCanceledBillsOwner"></s:url><s:a href="%{url}">View Canceled Bills</s:a></p>

                            </div>

    <div align="center" id="main_content">
        <h1 align="center">Invoice</h1>
        <table width="100%">
            <tr>
                <td>
                    <table align="right" width="30%" border="0"><tr>
                <td width="left">Bill No.</td><td>:</td><td align="right"><s:property value="#request.bill.number"></s:property></td></tr>
                <tr><td width="left">Bill Date</td><td>:</td><td align="right"><s:property value="#request.bill.billDate"></s:property></td></tr>
                <tr><td width="left">Status</td><td>:</td><td align="right"><s:property value="#request.bill.status"></s:property></td>
            </tr></table>
                </td>
            </tr>
            <tr>
                <td>
                    <s:if test="billItemsList.size() > 0">
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="10%">S. No</th>
              <th  align="center" width="60%">Item Name</th>
              <th  align="center" width="10%">Price</th>
              <th  align="center" width="10%">Quantity</th>
              <th  align="center" width="10%">Amount</th>
          </tr>
          <s:iterator value="billItemsList" status="id">
          <tr bgcolor="#e1e2f5">

               <td align="right" width="10%"><s:property value="%{#id.index+1}" /></td>
               <td align="left" width="60%"><s:property value="itemName" /></td>
               <td align="right" width="10%"><s:property value="itemPrice" /></td>
               <td align="right" width="10%"><s:property value="itemQuantity" /></td>
               <td align="right" width="10%"><s:property value="itemPrice*itemQuantity" /></td>

          </tr>
          </s:iterator>
          <tr>
              <td></td>
              <td colspan="3" align="right">Total Amount</td><td align="right"><s:property value="#request.bill.totalAmount"></s:property></td>
          </tr>
      </table>
    <p class="clear"></p>
                    </s:if>
                </td>
            </tr>
        </table>
        

        
   </div>
            <table width="100%"><tr><td><script>document.write("<input type='button' onClick='javascript:printInvoice();' class='printbutton' value='Print Invoice'/>");</script></td></tr></table>
            </div>
                    

            <div style="height:150px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
         <iframe name=print_frame width=0 height=0 frameborder=0 src=about:blank></iframe>
    </body>
</html>
