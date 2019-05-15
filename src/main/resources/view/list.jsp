<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>


${page}
<c:forEach items="${fanySingList}" var="fanySing" varStatus="vs">
    ${fanySing.issudate}<br/>
</c:forEach>

<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>