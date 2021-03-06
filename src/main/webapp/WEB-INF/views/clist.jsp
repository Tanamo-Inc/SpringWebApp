<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
        <s:url var="url_css" value="/static/css/main.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>

    <body class="bod">

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
                <td height="350px" valign="top" width="100%">

                    <%-- Page Content Area--%>
                    <h3>Contact List</h3>

                    <c:if test="${param.act eq 'save'}">
                        <p class="success">Contact Saved Successfully</p>
                    </c:if>

                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact Deleted Successfully</p>
                    </c:if>


                    <s:url var="url_search"  value="/user/contact_search"/>

                    <table width="100%">
                        <tr>
                            <td align="right" >
                                <form action="${url_search}">
                                    <input type="text" name="freeText" value="${param.freeText}" placeholder="search">
                                    <button>Search</button>
                                </form> 
                            </td>                           
                        </tr>
                    </table>


                    <form action="<s:url value="/user/bulk_cdelete"/>">        

                        <button>Multiple Delete</button> <br/><br/>                 

                        <table border="1" cellpadding="4"  width="100%">

                            <tr>
                                <th>SELECT</th>
                                <th>ID</th>
                                <th>NAME</th>
                                <th>PHONE</th>
                                <th>EMAIL</th>
                                <th>ADDRESS</th>
                                <th>REMARK</th>
                                <th>ACTION</th>
                            </tr>

                            <c:if test="${empty contactList}">
                                <tr>
                                    <td align="center" colspan="8" class="error">No Records Present</td>
                                </tr>
                            </c:if>

                            <c:forEach var="c" items="${contactList}" varStatus="st">

                                <tr>
                                    <td align="center"><input type="checkbox" name="cid" value="${c.id}"/></td>
                                    <td>${c.id}</td>
                                    <td>${c.cName}</td>
                                    <td>${c.phone}</td>
                                    <td>${c.email}</td>
                                    <td>${c.address}</td>
                                    <td>${c.remark}</td> 

                                    <s:url var="url_del" value="/user/del_contact">
                                        <s:param name="cid" value="${c.id}"/>
                                    </s:url>  


                                    <s:url var="url_edit" value="/user/edit_contact">
                                        <s:param name="cid" value="${c.id}"/>
                                    </s:url> 



                                    <td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>

                                </tr> 

                            </c:forEach>

                        </table>

                    </form>  

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
