<%-- 
    Document   : menu
    Created on : Aug 31, 2018, 6:49:19 PM
    Author     : Tanamo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


<s:url var="lgo" value="/logout"/>

<c:if test="${sessionScope._id==null}"  >
    <%--Guest Menu--%>

    <a href="#">Home</a>|<a href="#">Register</a>|<a href="#">Login</a>|<a href="#">About</a>

</c:if>

<c:if test="${sessionScope._id!=null && sessionScope.role == 1}">
    <%-- Admin Menu --%>    
    <a href="#">Home</a> | <a href="#">User List</a> | <a href="${lgo}">Logout</a>  
</c:if>


<c:if test="${sessionScope._id!=null && sessionScope.role == 2}">
    <%-- User Menu --%>    
    <a href="#">Home</a> | <a href="#">Add Contact</a> | <a href="#">Contact List</a>| <a href="${lgo}">Logout</a>  
</c:if>
