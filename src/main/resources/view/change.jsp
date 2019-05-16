<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入头 --%>
<c:import url="header/header.jsp"/>

<form>
    <c:forEach var="items" items="${id}">

        <table class="table table-bordered">
            <tr>
                <td>
                    <p>修改id    ${items}</p>
                    <input type="hidden" name="id" value="${items}">
                </td>
            </tr>
            <tr>
                <td>
                    <p>名称 <input type="text" name="name"/></p>
                </td>
            </tr>
        </table>

    </c:forEach>
    <input type="submit" value="提交"/>
</form>



<%-- 引入尾 --%>
<c:import url="footer/footer.jsp"/>