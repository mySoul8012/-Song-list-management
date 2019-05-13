<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>


<c:url value="/list.html" var="list">
    <c:param name="page" value="0"/>
</c:url>
<a href="${list}">歌曲库列表</a>



<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>