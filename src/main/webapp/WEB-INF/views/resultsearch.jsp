<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--<jsp:include page="search.jsp"/>--%>

<table id="example" class="table table-striped table-bordered" style="width:40%">
    <tr>
        <th>Name</th>
        <th>Guid</th>
        <th>Ip</th>
        <th>Akcja</th>

    </tr>
    <c:forEach items="${result}" var="res">

        <tr>
            <td> ${res.name}</td>
            <td> ${res.guid}</td>
            <td> ${res.ip}</td>

            <td> <a href="../user/ban/${res.id}"> ban </a></td>
            <%--<td> <a href="../user/del/${server.id}">del</a><br></td>--%>

        </tr>

    </c:forEach>
</table>


<jsp:include page="footer.jsp"/>

</body>
</html>
