
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="paginatedList.size() > 0">
    <table border="1" width="970px" cellpadding="2" cellspacing="2" align="center">
          <tr bgcolor="#e1e2f5">
              <th  align="center" width="5%">S.No</th>
              <th  align="center" width="9%">Latitude</th>
              <th  align="center" width="9%">Longitude</th>
              <th  align="center" width="13%">Location Name</th>
              <th  align="center" width="16%">Location Title</th>
              <th  align="center">Location Info</th>
              <th  align="center" width="8%">Status</th>
              <th  align="center" width="5%">Edit</th>
          </tr>
          <s:iterator value="paginatedList" status="id">
          <tr >
               <td align="center" width="5%"><s:property value="%{(pageNo-1)*recordsPerPage+(#id.index+1)}" /></td>
               <td align="right" width="9%"><s:property value="latitude" /></td>
               <td align="right" width="9%"><s:property value="longitude" /></td>
               <td align="left" width="13%"><s:property value="locationName" /></td>
               <td align="left" width="16%"><s:property value="locationTitle" /></td>
               <td align="justify" ><s:property value="locationInfo" /></td>
               <td align="center" width="8%"><s:property value="workStatus" /></td>
               <td align="center" width="5%">
                   <s:url var="url" action="editLocation">
                       <s:param name="id"><s:property value="id"/></s:param>
                   </s:url>
                   <s:a href="%{url}">Edit</s:a>
               </td>

          </tr>
          </s:iterator>
      </table>
    <p class="clear"></p>
    <p>Page No - <s:property value="pageNo" /></p>
                    </s:if>
                 <s:else>
                    <blockquote class="blockquote">No Records Found</blockquote>
                </s:else>