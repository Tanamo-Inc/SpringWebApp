<%-- 
    Document   : index
    Created on : Aug 28, 2018, 4:04:01 PM
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

        <table border="1" width="85%" align="center">

            <%-- Header --%>
            <tr>
                <td height="90px">

                    <jsp:include page="include/header.jsp"/>

                </td>
            </tr>

            <tr>
                <td height="30px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>

                </td>
            </tr>

            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <h3>User Login</h3>

                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>

                    <c:if test="${param.act eq 'lo'}">
                        <p class="success">Logout Successfully!!!</p>
                    </c:if>    

                    <c:if test="${param.act eq 'reg'}">
                        <p class="success">User Registered Successfully. Please login</p>
                    </c:if> 

                    <s:url var="url_login"  value="/login"/>

                    <s:url var="url_register"  value="/reg_form"/>

                    <f:form  class="forma" action="${url_login}" modelAttribute="command_login">

                        <table border="2">

                            <tr>
                                <td>Username</td>
                                <td><f:input path="loginName" /> </td>
                            </tr>

                            <tr>
                                <td>Password</td>
                                <td><f:password path="password" /> </td>
                            </tr>

                            <tr>                                
                                <td colspan="2" align="right">
                                    <button>Login</button> <br/>
                                    <a href="${url_register}">New User Registration</a>
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
