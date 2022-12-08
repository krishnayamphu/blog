<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp"%>
    <title>Register new user</title>
</head>
<body>
<%@include file="/admin/header.jsp"%>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp"%>
    </div>
    <div class="content">
        <form action="register" method="post">
            <label>Username</label>
            <input type="text" name="username" required>

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Password</label>
            <input type="password" name="password" required>
            <button type="submit">Register</button>
        </form>
    </div>
</main>
</body>
</html>
