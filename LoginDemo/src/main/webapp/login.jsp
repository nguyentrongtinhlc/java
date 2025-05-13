<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Form Đăng Nhập</h2>
    <form method="post" action="login">
        Tên đăng nhập: <input type="text" name="username" /><br/>
        Mật khẩu: <input type="password" name="password" /><br/>
        <input type="submit" value="Đăng nhập" />
    </form>

    <c:if test="${not empty error}">
        <p style="color:red;"><c:out value="${error}" /></p>
    </c:if>
</body>
</html>
