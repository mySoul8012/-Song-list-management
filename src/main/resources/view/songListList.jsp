<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>


<table style="width: 500px;" class="table table-striped table-hover table-bordered">
    <tr>
        <td>歌单项id</td>
        <td>歌曲id</td>
        <td>歌曲名称</td>
        <td>描述</td>
        <td>创建者id</td>
    </tr>
    <c:forEach items="${ListSongList}" var="List" varStatus="vs">
        <tr>
            <td>${List.id}</td>
            <td>${List.singId}</td>
            <td>${List.name}</td>
            <td>${List.description}</td>
            <td>${List.creator}</td>
        </tr>
    </c:forEach>
</table>


<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>