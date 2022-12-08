<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp"%>
    <title>New Post</title>
</head>
<body>
<%@include file="/admin/header.jsp"%>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp"%>
    </div>
    <div class="content">
        <h4>New Post</h4>
        <form action="post-create" method="post">
            <label>Title</label>
            <input type="text" name="title" required>

            <label>Content</label>
            <textarea name="content" id="" cols="30" rows="10"></textarea>

            <label>Picture</label>
            <img src="" id="thumb" alt="">
            <button type="button" onclick="showDailog()">Set Picture</button>
            <input type="hidden" id="pic" name="pic">

            <button type="submit">Create Post</button>
        </form>
    </div>
</main>
<div id="media" class="media-overlay">
    <div class="media-container">
        <div class="media-header">
            <h4>All Image Files</h4>
            <button onclick="closeDailog()"> X </button>
        </div>

        <c:forEach var="item" items="${files}">
            <div class="card">
                <img onclick="setImage('${item}')" src="uploads/${item}" alt="${item}">
            </div>
        </c:forEach>
    </div>
</div>

<script>
    function setImage(name){
        document.getElementById("pic").value=name;
        document.getElementById("thumb").src="uploads/"+name;
        document.getElementById("thumb").style.display="block";
        closeDailog();
    }
    function showDailog(){
        document.getElementById("media").style.display="flex";
    }
    function closeDailog(){
        document.getElementById("media").style.display="none";
    }
</script>
</body>
</html>
