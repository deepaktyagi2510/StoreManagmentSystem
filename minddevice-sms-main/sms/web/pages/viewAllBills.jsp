

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
                 <div id="side_navigation"><h1>Billing</h1>

                                <p align="center"><s:url var="url" action="createBill"></s:url><s:a href="%{url}">New Bill</s:a></p>
                                <p align="center"><s:url var="url" action="viewAllBills"></s:url><s:a href="%{url}">View All Bills</s:a></p>
                                <p align="center"><s:url var="url" action="searchBill"></s:url><s:a href="%{url}">Search a Bill</s:a></p>
                                <p align="center"><s:url var="url" action="viewCanceledBills"></s:url><s:a href="%{url}">View Canceled Bills</s:a></p>

                            </div>

    <div align="center" id="main_content">
        <h1 align="center">List of Bills</h1>
        <s:if test="billList.size() > 0">
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
        <tr bgcolor="#e1e2f5" >
              <th  align="center" width="4%">Bill No</th>
              <th  align="center" width="9%">Date</th>
              <th  align="center" width="16%">Amount</th>
              <th  align="center" width="5%">Cancel Bill</th>
          </tr>
          <s:iterator value="billList" status="id">
          <tr  bgcolor="#e1e2f5">
               <s:url var="viewBillUrl" action="viewBill">
                       <s:param name="id"><s:property value="number"/></s:param>
                   </s:url>
               <td align="right" width="4%"><s:a href="%{viewBillUrl}"><s:property value="number" /></s:a></td>
               <td align="right" width="9%"><s:property value="billDate" /></td>
               <td align="right" ><s:property value="totalAmount" /></td>
               <td align="center" width="5%">
                   <s:url var="url" action="cancelBill">
                       <s:param name="id"><s:property value="number"/></s:param>
                   </s:url>
                   <s:a href="%{url}">Cancel</s:a>
               </td>

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
