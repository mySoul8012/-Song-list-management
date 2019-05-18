<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>

<div class="container">
    <form action="/change.html" method="get">
        <table style="width: 500px;" class="table table-striped table-hover table-bordered">
            <thead>
                <tr>
                    <th>选择</th>
                    <th>歌曲id</th>
                    <th>歌曲名称</th>
                    <th>演唱者</th>
                    <th>类别</th>
                    <th>做词</th>
                    <th>语言</th>
                    <th>发行日期</th>
                    <th>添加到我的收藏</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${fanySingList}" var="fanySing" varStatus="vs">
                    <tr>
                        <label>
                            <td>
                                <input type="checkbox" value="${fanySing.id}" name="id">
                            </td>
                            <td>${fanySing.id}</td>
                            <td>${fanySing.name}</td>
                            <td>${fanySing.singer}</td>
                            <td>${fanySing.category}</td>
                            <td>${fanySing.writer}</td>
                            <td>${fanySing.language}</td>
                            <td>${fanySing.issudate}</td>
                            <td><a href="/AddSongSongList.html?id=${fanySing.id}&userId=1">添加到我的收藏</a></td>
                        </label>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="修改">
    </form>
</div>

<!-- 上下一页 -->
<!-- 上一页 -->
<c:url value="list.html" var="PreviousPage">
    <c:param name="page" value="${page - 1}"/>
</c:url>
<c:if test="${page > 1}">
    <a href="${PreviousPage}">
        <button type="button" class="btn btn-default">上一页</button>
    </a>
</c:if>

<!-- 下一页 -->
<c:url value="list.html" var="NextPage">
    <c:param name="page" value="${page + 1}"/>
</c:url>
<c:if test="${page < pages}">
    <a href="${NextPage}">
        <button type="button" class="btn btn-default">下一页</button>
    </a>
</c:if>


<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>