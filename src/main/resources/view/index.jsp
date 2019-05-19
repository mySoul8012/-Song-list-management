<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>



<div class="container">
    <div class="jumbotron">
        <h1>欢迎进入首页！</h1>
        <p>这是一个首页</p>
        <p><a href="ListSongListList.html?createId=1" class="btn btn-primary btn-lg" role="button">
            查看我已经收藏的歌单</a>
        </p>
    </div>
</div>


<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>