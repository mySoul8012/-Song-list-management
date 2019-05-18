<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>


<a href="list.html">歌曲库列表</a>
<br/>
默认以用户id为1的用户身份添加歌曲到歌单 每次添加默认默认更新用户id为1的表单

<br/>

查看我的收藏的歌曲
<a href="ListSongListList.html?createId=1">查看我的收藏的歌曲</a>


<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>