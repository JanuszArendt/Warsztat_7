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

<form:form method="post" modelAttribute="player"> <br>

    Search: <form:input path="name"></form:input>

    <form:errors path="name"/>

    <input type="submit" value="Search">

</form:form>

<jsp:include page="footer.jsp"/>
</body>
</html>
