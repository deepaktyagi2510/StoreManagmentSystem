

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
                 <div id="side_navigation"><h1>Items</h1>

                                <p align="center"><s:url var="url" action="addItem"></s:url><s:a href="%{url}">Add Item</s:a></p>
                                <p align="center"><s:url var="url" action="viewAllItems"></s:url><s:a href="%{url}">View All Items</s:a></p>
                                <p align="center"><s:url var="url" action="searchItem"></s:url><s:a href="%{url}">Search an Item</s:a></p>

                            </div>

    <div align="center" id="main_content">
        <h1 align="center">Search Item</h1>
        <table align="center">
            <tr><td>&nbsp; <br/><br/></td></tr>
            <tr>
                <td>
        <s:form action="processSearchItem">

                <s:textfield name="itemName" labelSeparator=" : " label="Enter Item Name" size="20"/>
                <s:submit type="submit" value="Search" cssClass="button"/>

          </s:form>  <br/><br/> <br/></td>
            </tr>
</table>

   </div>
            </div>
            <div style="height:300px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>