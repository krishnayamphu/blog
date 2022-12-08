<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ky.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp"%>
    <title>Users</title>
</head>
<body>
<%@include file="/admin/header.jsp"%>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp"%>
    </div>
    <div class="content">
        <h4>All Users</h4>
        <table class="tbl-users">
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Picture</th>
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td><img src="uploads/>${user.picture}" width="100px" alt=""></td>
                    <td>
                        <div class="action-group">
                            <a href="user-edit?id=${user.id}">Edit</a>
                            <form class="form-action" action="users" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <button>Delete</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>

</body>
</html>
