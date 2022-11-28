<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ky.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Posts</title>
</head>
<body>
<header>
    <h4>All Posts</h4>
</header>

<table class="tbl-users">
    <tr>
        <th>Title</th>
        <th>Picture</th>
        <th>Author</th>
        <th>Created Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.title}</td>
            <td><img src="uploads/>${user.picture}" width="100px" alt=""></td>
            <td>${post.userId}</td>
            <td>${post.createdAt}</td>
            <td>
                <div class="action-group">
                    <a href="user-edit?id=${post.id}">Edit</a>
                    <form class="form-action" action="users" method="post">
                        <input type="hidden" name="id" value="${post.id}">
                        <button>Delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
