

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="common_import.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@ include file="common_include.jsp" %>
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
        <h1 align="center">Item Wise Sell</h1>
        <s:if test="billItemsList.size() > 0">
            <p align="right" style="color: tomato; padding-right: 10px">Total Sale of <s:property value="itemName"></s:property> - <s:property value="totalAmount"></s:property>
        </p> 
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="8%">S. No</th>
              <th  align="center" width="10%">Bill No</th>
              <th  align="center" width="10%">Bill Date</th>
              <th  align="center" width="40%">Item Name</th>
              <th  align="center" width="10%">Price</th>
              <th  align="center" width="7%">Quantity</th>
              <th  align="center" width="10%">Amount</th>
          </tr>
          <s:iterator value="billItemsList" status="id">
          <tr bgcolor="#e1e2f5">

               <td align="center" width="8%"><s:property value="%{#id.index+1}" /></td>
               <s:url var="viewSearchBillUrl" action="viewSearchBill">
                       <s:param name="id"><s:property value="billNumber"/></s:param>
                   </s:url>
               <td align="right" width="10%"><s:a href="%{viewSearchBillUrl}"><s:property value="billNumber" /></s:a></td>
               <td align="right" width="10%"><s:property value="itemDate" /></td>
               <td align="left" width="40%">&nbsp;<s:property value="itemName" /></td>
               <td align="right" width="10%"><s:property value="itemPrice" /></td>
               <td align="right" width="7%" ><s:property value="itemQuantity" /></td>
               <td align="right" width="55%" ><s:property value="itemPrice*itemQuantity" /></td>

          </tr>
          </s:iterator>
      </table>
    <p class="clear"></p>
                    </s:if>
     <s:else>
                    <blockquote class="blockquote">No Records Found</blockquote>
                </s:else>
   </div>
            </div>
            <div style="height:500px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
