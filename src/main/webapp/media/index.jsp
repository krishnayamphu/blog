<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp"%>
    <title>Media Files</title>
</head>
<body>
<%@include file="/admin/header.jsp"%>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp"%>
    </div>
    <div class="content">
        <form class="media-upload" method="POST" enctype="multipart/form-data" action="media">
            <label>                Upload:</label>
            <input type="file" name="upfile">
            <button type="submit">Upload</button>
        </form>
        <hr>
        <h3>All Files</h3>
        <c:forEach var="item" items="${files}">
            <div class="media-thumb">
                <img src="uploads/${item}" alt="${item}">
                <div class="media-action">
                    <a href="uploads/${item}">View</a>
                    <form action="media-del" method="post">
                        <input type="hidden" name="pic" value="${item}">
                        <button>Delete</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

</body>
</html>
