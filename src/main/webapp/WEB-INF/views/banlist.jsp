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

        <h2> Ban list</h2>

    <table id="example" class="table table-striped table-bordered" style="width:50%">
        <tr>
            <th>Name</th>
            <th>GUID</th>
            <th>Ip</th>
            <th>Remove</th>
            <th><a href="savebanlist"> Save</a></th>

        </tr>
        <c:forEach items="${ban}" var="bb">

            <tr>
                <td> ${bb.name}</td>
                <td> ${bb.guid}</td>
                <td> ${bb.ip}</td>

                <td> <a href="../user/delbanlist/${bb.id}">del</a>

            </tr>

        </c:forEach>
    </table>

</div>



<jsp:include page="footer.jsp"/>
</body>
</html>
