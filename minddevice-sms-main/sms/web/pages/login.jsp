
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
    <body style="padding-top:30px;">
        <div  id="wrapper">
            <div id="header"><%@ include file="header.jsp" %></div>
            <!--<div id="menu"><%@ include file="menu.jsp" %></div>-->
            <div id="content">
    
                <h1 align="center">LOGIN</h1>
        <table align="center">
            <tr><td>&nbsp; <br/><br/></td></tr>
            <tr>
                <td>
        <s:form action="login">
             
            <s:textfield name="userName" labelSeparator=" : " label="User Name" size="20"/>
                <s:password name="password" labelSeparator=" : " label="Password" size="21"/>
                <s:submit type="submit" value="Login"/>
                    
          </s:form></td>
            </tr>
</table>
            </div>
          <div style="height:100px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>

