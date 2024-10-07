

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="common_import.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <%@ include file="common_include.jsp" %>
    </head>
    <body style="padding-top:30px;">
        <div  id="wrapper">
            <div id="header"><%@ include file="header.jsp" %></div>
            <!--<div id="menu"><%@ include file="menu.jsp" %></div>-->
            <div id="content">
                <p>
                            You are logged out successfully
                </p>
                <p align="center"><s:url var="url" action="home"></s:url><s:a href="%{url}">Login Again</s:a></p>


            </div>
            <div style="height:212px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
