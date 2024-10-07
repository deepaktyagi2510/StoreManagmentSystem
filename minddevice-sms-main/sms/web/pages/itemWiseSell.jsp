

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
        <h1 align="center">Search By Items Name</h1>
        <table align="center">
            <tr><td>&nbsp; <br/><br/></td></tr>
            <tr>
                <td>
        <s:form action="viewItemWiseSell">

                <s:select name="itemId" id="itemId" labelSeparator=" : " label="Item Name" headerKey="" headerValue="Select" list="%{#application.itemListInAppScope}"
                      listValue="name" listKey="id"/>
                <s:submit type="submit" value="Find" cssClass="button"/>

          </s:form><br/><br/><br/><br/><br/><br/><br/><br/></td>
            </tr>
</table>
   </div>
            </div>
            <div style="height:500px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
