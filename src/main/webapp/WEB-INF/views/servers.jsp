<%--
  Created by IntelliJ IDEA.
  User: janusz
  Date: 14.11.18
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>Project</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="content-wrapper">
    <%--Witaj ${user.name}--%>

    <h2>Servers </h2>




    <table id="example" class="table table-striped table-bordered" style="width:40%">
        <tr>
            <th>Name</th>
            <th>Upload</th>
            <security:authorize access="hasRole('ADMIN')">
            <th>Del Server</th>
            </security:authorize><br></td>
        </tr>
        <c:forEach items="${servers}" var="server">

            <tr>
                <td> ${server.name}</td>
                <td> <a href="/user/upload"> upload </a>     </td>
                <security:authorize access="hasRole('ADMIN')">
                <td> <a href="../user/del/${server.id}">del</a>
                    </security:authorize><br></td>
            </tr>

        </c:forEach>
    </table>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

