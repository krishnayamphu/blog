<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ky.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp" %>
    <title>Posts</title>
</head>
<body>
<%@include file="/admin/header.jsp" %>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp" %>
    </div>
    <div class="content">
        <h4>All Posts</h4>
        <table class="tbl-users">
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Created Date</th>
                <th>Action</th>
            </tr>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.title}</td>
                    <td>${post.userId}</td>
                    <td>${post.createdAt}</td>
                    <td>
                        <div class="action-group">
                            <a href="post-edit?id=${post.id}">Edit</a>
                            <form class="form-action" action="posts" method="post">
                                <input type="hidden" name="id" value="${post.id}">
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
