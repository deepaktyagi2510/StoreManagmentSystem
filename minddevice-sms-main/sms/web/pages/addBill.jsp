

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

    <div  id="main_content">
        <h1 align="center">Create Bill</h1>
        
            <s:form action="addItemInBill" id="addItemInBill">
                <table align="left" border="0" style="padding:0 0 20px 45px; margin-top:12px; ">
                   
               <tr>
                   <td align="left">Item Name</td>
                   <td align="left"> :</td>
                   <td align="left"> <s:select  theme="simple" name="itemId" id="itemId" labelSeparator=" : " label="Item Name" headerKey="" headerValue="Select" list="%{#application.itemListInAppScope}"
                          listValue="name" listKey="id" onchange="javascript:show_price();return false;"/></td><td align="left"><s:fielderror fieldName="itemId"/></td></tr>
                <s:url id="show_price_url" action="showItemPrice"/>
                <tr><td align="left">Item Price</td><td align="left"> :</td><td align="left"> <sx:div theme="simple"  href="%{show_price_url}" listenTopics="show_price" formId="addItemInBill" showLoadingText="Loading..." ></sx:div></td><td></td></tr>
                <tr><td align="left">Quantity</td><td align="left"> :</td><td align="left">  <s:textfield theme="simple"  name="itemQuantity" id="itemQuantity" labelSeparator=" : " label="Item Quantity" size="20" onchange="javascript:calculateTotal();"/> (in Kg. please use decimal for grams)</td><td align="left"><s:fielderror fieldName="itemQuantity" /></td></tr>
                <tr> <td align="left">Amount</td><td align="left"> :</td><td align="left">  <s:textfield theme="simple"  name="total" id="total" labelSeparator=" : " label="Total" size="20" readonly="true"/></td></tr>
                <tr><td align="left"></td><td align="left"></td><td align="left"> <s:submit theme="simple" type="submit" value="Add Item in Bill" cssClass="button"/></td></tr>
 </table>
          </s:form>
       
<p class="clear"></p>
           
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
        <s:if test="%{#session.billItemsList.size() > 0}">
          <tr>
              <td colspan="6" align="right"><span style="color: tomato;">Total - <s:property value="%{#session.totalAmountOfBill}"></s:property></span></td>
          </tr>
          </s:if>
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="5%">S. No </th>
              <th  align="center" width="50%">Item Name</th>
              <th  align="center" width="10%">Quantity</th>
              <th  align="center" width="10%">Price</th>
              <th  align="center" width="10%">Amount</th>
              <th  align="center" width="5%">Cancel</th>
          </tr>
          <s:if test="%{#session.billItemsList.size() > 0}">
              <s:form action="processCreateBill" theme="simple">
          <s:iterator value="#session.billItemsList" status="id">
              <tr bgcolor="#e1e2f5">
               <td align="center" width="5%"><s:property value="%{#id.index+1}" /></td>
               <td align="left"  width="50%">&nbsp;<s:property value="itemName" /></td>
               <td align="right" width="10%"><s:property value="itemQuantity" />&nbsp;</td>
               <td align="right" width="10%"><s:property value="itemPrice" />&nbsp;</td>
               <td align="right" width="10%"><s:property value="itemQuantity*itemPrice" />&nbsp;</td>
               <td align="center" width="10%">
                   <s:url var="url" action="deleteItemFromBill">
                       <s:param name="id"><s:property value="%{#id.index}"/></s:param>
                   </s:url>
                   <s:a href="%{url}">Cancel</s:a>
               </td>

          </tr>
          </s:iterator>
          <tr><td></td><td align="right"> <s:submit type="submit" value="Create Bill"/></td><td></td><td></td><td></td><td></td></tr>
         

          </s:form>
          </s:if></table>
                 <s:else>
                    <blockquote class="blockquote">No Items</blockquote>
                </s:else>
      
    <p class="clear"></p>
          
   </div>
            </div>
            <div style="height:500px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
