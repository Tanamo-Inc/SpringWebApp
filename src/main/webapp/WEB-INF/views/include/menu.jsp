<%-- 
    Document   : menu
    Created on : Aug 31, 2018, 6:49:19 PM
    Author     : Tanamo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<s:url var="lgo" value="/logout"/>

<c:if test="${sessionScope._id==null}"  >
    <%--Guest Menu--%>
    <s:url var="url_reg_form" value="/reg_form"/>
    <s:url var="url_index" value="/index"/>
    <s:url var="url_login" value="/login"/>

    <a href="${url_index}">Home</a>|<a href="${url_reg_form}">Register</a>|<a href="https://tanamo-inc.github.io/Home/">About</a>

</c:if>

<c:if test="${sessionScope._id!=null && sessionScope.role == 1}">
    <%-- Admin Menu --%>    
    <a href="#">Home</a> | <a href="<s:url value="/admin/users"/>">User List</a> | <a href="${lgo}">Logout</a>  
</c:if>

<c:if test="${sessionScope._id!=null && sessionScope.role == 2}">
    <%-- User Menu --%>    
    <s:url var="url_uhome" value="/user/user_dashboard"/>
    <s:url var="url_cform" value="/user/contact_form"/>
    <s:url var="url_clist" value="/user/clist"/>
    <a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${lgo}">Logout</a>  
</c:if>
