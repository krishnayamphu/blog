<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <title>User Login</title>
</head>
<body>
<div class="login-container">
    <form class="login-form" action="login" method="post">
        <c:if test="${err!=null}">
            <p class="text-error">${err}</p>
        </c:if>
        <label>Username</label>
        <input type="text" name="username" required>
        <label>Password</label>
        <input type="password" name="password" required>
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>
