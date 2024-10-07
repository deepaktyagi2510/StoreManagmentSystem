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
                <table width="100%" border="1">
                    <tr>
                        <td width="30%">
                            <div id="side_navigation"><h1>&nbsp;&nbsp;&nbsp;Side Navigation</h1>

                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>
                                <p align="center"><s:url var="url" action="logout"></s:url><s:a href="%{url}">Logout</s:a></p>

                            </div>
                        </td>
                        <td width="70%">
                            <div id="right2">
    <h1>&nbsp;&nbsp;&nbsp;Success</h1>

    <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>

</div>
                        </td>
                    </tr>
                </table>


            </div>
            <div style="height:500px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
