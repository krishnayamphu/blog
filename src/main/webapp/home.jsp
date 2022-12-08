<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ky.utils.PostContent" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <title>Blog | Home</title>
</head>
<body>
<nav>
    <div class="container">
        <a href="home">Blog</a>
        <a href="contact">Contact</a>
        <a href="login">Login</a>
    </div>
</nav>

<main>
    <div class="container">
        <div class="content">
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <h3><a href="single?id=${post.id}">${post.title}</a></h3>
                    <span>${post.createdAt}</span>
                    <div class="post-content">
                        <c:if test="${post.picture!=''}">
                            <img src="uploads/${post.picture}" alt="${post.picture}">
                        </c:if>
                        <p>${PostContent.excerpt(post.content,100)}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="sidebar">
            <h3>Latest Updates</h3>
            <ul class="post-latest">
                <c:forEach var="post" items="${latestPosts}">
                    <li><a href="single?id=${post.id}">${post.title}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</main>
</body>
</html>
