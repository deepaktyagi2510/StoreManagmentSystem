

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
        <h1 align="center">Search Bill</h1>
        <table align="center"  border="0">
            <tr><td>&nbsp; <br/><br/></td></tr>
            <tr>
                <td>
        <s:form action="processSearchBill">

            <s:textfield name="billNumber" labelSeparator=" : " label="Enter Bill Number" size="20"/>
            <s:submit type="submit" value="Search Bill" cssClass="button"/>

          </s:form>&nbsp;<br/> <br/><br/>
                </td>
            </tr>
</table>

   </div>
            </div>
            <div style="height:300px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
