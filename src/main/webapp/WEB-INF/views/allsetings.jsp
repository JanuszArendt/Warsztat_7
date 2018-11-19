
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

    <h2>Setngs </h2>




    <table id="example" class="table table-striped table-bordered" style="width:40%">
        <tr>
            <th>Description</th>


            <security:authorize access="hasRole('ADMIN')">
            <th>Set</th>
                <th><a href="savesetings"> Save</a></th>
            </security:authorize><br>

        </tr>
        <c:forEach items="${set}" var="seting">

            <tr>
                <td> ${seting.descriotion}</td>

                <security:authorize access="hasRole('ADMIN')">
                <td> <a href="../user/set/${seting.id}">${seting.slected}</a>
                    </security:authorize><br></td>
            </tr>

        </c:forEach>
    </table>

</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

