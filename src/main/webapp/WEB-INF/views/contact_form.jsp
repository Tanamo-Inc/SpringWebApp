<%-- 
    Document   : contact_form
    Created on : Sep 5, 2018, 7:29:53 AM
    Author     : Tanamo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tanamo Inc</title>
        <s:url var="url_css" value="/static/css/main.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>

    <body class="bod" >

        <table border="1" width="80%" align="center">

            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>

                </td>
            </tr>

            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>

                </td>
            </tr>

            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <h3>Contact Form</h3>

                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>

                    <s:url var="url_savec"  value="/user/save_contact"/>

                    <f:form class="forma" action="${url_savec}" modelAttribute="command">

                        <table border="1">

                            <tr>
                                <td>Name</td>
                                <td><f:input path="cName" /> </td>
                            </tr>

                            <tr>
                                <td>Phone Number</td>
                                <td><f:input path="phone" /> </td>
                            </tr>

                            <tr>
                                <td>Email</td>
                                <td><f:input path="email" /> </td>
                            </tr>

                            <tr>
                                <td>Address</td>
                                <td><f:textarea path="address" /> </td>
                            </tr>

                            <tr>
                                <td>Remarks</td>
                                <td><f:textarea path="remark" /> </td>
                            </tr>

                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Save</button> 
                                </td>
                            </tr>

                        </table>

                    </f:form>

                </td>
            </tr>

            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>

        </table>

    </body>

</html>
