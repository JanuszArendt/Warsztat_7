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
<%--bDefaultAllowChangeMapVoting=false--%>
<%--bDefaultAllowSetNextMapVoting=false--%>
<%--bDefaultAllowRestartMissionVoting=false--%>
<%--bDefaultAllowAARMapVoting=false--%>
<%--bDefaultAllowEnemyFireMapDot=false--%>
<%--bDefaultAutoReloadEnabled=false--%>
<%--bDefaultAnchoringAllowed=false--%>
<%--bDefaultHUD_ForceInWorldEnemySpots=false--%>
<%--bDefaultUseRoles=false--%>


<form:form method="post" modelAttribute="seting"> <br>
    Description <form:input path="descriotion" />
    <input type="submit" value="Save">

</form:form>


<jsp:include page="footer.jsp"/>
</body>
</html>
