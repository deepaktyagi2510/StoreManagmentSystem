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
        <h1 align="center">Success</h1><br/><br/>
        <p style="font-size: 16px; color: tomato;"> <s:property value="message"></s:property></p><br/><br/><br/>
        <s:url var="viewInvoice" action="viewBill">
                       <s:param name="id"><s:property value="billNoToShowInvoice"/></s:param>
                   </s:url>
        <p style="font-size: 16px; color:green"><s:a href="%{viewInvoice}">INVOICE</s:a></p><br/><br/><br/>
     </div>
            </div>
            <div style="height:500px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
