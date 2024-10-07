

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
                
                <div id="side_navigation"><h1>Links</h1>

                                <p align="center"><s:url var="url" action="createBill"></s:url><s:a href="%{url}">Billing</s:a></p>
                                <p align="center"><s:url var="url" action="search"></s:url><s:a href="%{url}">Search</s:a></p>
                                <p align="center"><s:url var="url" action="viewAllItems"></s:url><s:a href="%{url}">Items</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>

                            </div>
                            <div id="main_content"><h1>Welcome</h1>
                                <p style="font-size: 20px; color:cadetblue;">Sales Management System </p>
                                <p style="font-size: 16px; color:cadetblue;">A Product of Minddevice Technologies</p>
                                <p>&nbsp;</p>
                                <p>&nbsp;</p>
                            </div>
                       
            </div>
            <div style="height:350px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
