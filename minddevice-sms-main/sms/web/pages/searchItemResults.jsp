

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
        <h1 align="center">Search Item List</h1>
        <s:if test="itemList.size() > 0">
    <table border="0" width="100%" cellpadding="2" cellspacing="2" align="center">
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="10%">S. No.</th>
              <th  align="center" width="40%">Name</th>
              <th  align="center" width="10%">Price/kg/piece</th>
              <th  align="center" width="10%">Edit</th>
              <th  align="center" width="10%">Delete</th>
          </tr>
          <s:iterator value="itemList" status="id">
          <tr bgcolor="#e1e2f5">
               <td align="right" width="10%"><s:property value="%{#id.index+1}" /></td>
               <td align="left" width="40%"><s:property value="name" /></td>
               <td align="right" width="10%"><s:property value="price" /></td>
               <td align="center" width="10%">
                   <s:url var="url" action="editItem">
                       <s:param name="id"><s:property value="id"/></s:param>
                   </s:url>
                   <s:a href="%{url}">Edit</s:a>
               </td>
               <td align="center" width="5%">
                   <s:url var="url" action="deleteItem">
                       <s:param name="id"><s:property value="id"/></s:param>
                   </s:url>
                   <s:a href="%{url}">Delete</s:a>
               </td>

          </tr>
          </s:iterator>
          <tr><td colspan="5">&nbsp;</td></tr>
          <tr><td colspan="5">&nbsp;</td></tr>
          <tr><td colspan="5">&nbsp;</td></tr>
    </table>
    <p class="clear"></p>
                    </s:if>
                 <s:else>
                    <blockquote class="blockquote">No Records Found</blockquote>
                </s:else>

   </div>
            </div>
            <div style="height:250px;">&nbsp;</div>
            <div id="footer"><%@ include file="footer.jsp" %></div>
        </div>
    </body>
</html>
