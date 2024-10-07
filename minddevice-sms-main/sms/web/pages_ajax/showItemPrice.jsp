
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:textfield theme="simple" name="itemPrice" id="itemPrice" labelSeparator=" : " label="Item Price" size="20" >
    <s:param name="value">
                                <s:property value="itemPrice"/>
                            </s:param>
</s:textfield>