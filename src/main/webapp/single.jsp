<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <title>Blog | ${post.title}</title>
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
                <div class="post">
                    <h1>${post.title}</h1>
                    <span>${post.createdAt}</span>
                    <div class="post-single">
                        <c:if test="${post.picture!=''}">
                            <img class="img-thumb" src="uploads/${post.picture}" alt="${post.picture}">
                        </c:if>
                        <p>${post.content}</p>
                    </div>
                </div>
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
