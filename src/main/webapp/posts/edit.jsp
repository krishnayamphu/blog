<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ky.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/head.jsp"%>
    <title>Post Details</title>
</head>
<body>
<%@include file="/admin/header.jsp"%>
<main>
    <div class="sidebar">
        <%@include file="/admin/sidebar.jsp"%>
    </div>
    <div class="content">
        <h4>Post Details</h4>
        <form action="post-edit" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <input type="hidden" name="picture" value="${post.picture}">
            <input type="text" name="title" value="${post.title}" placeholder="Title" required>
            <br><br>
            <textarea name="content" id="" cols="30" rows="10">${post.content}</textarea>
            <br><br>
            <label>Picture</label>
            <input type="hidden" id="pic" name="pic" value="${post.picture!=''?post.picture:''}">
            <c:if test="${post.picture!=''}">
                <img id="thumbnail" src="uploads/${post.picture}" alt="">
            </c:if>
            <button type="button" onclick="showDailog()">Set Picture</button>
            <br><br>
            <button>Update</button>
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
        document.getElementById("thumbnail").src="uploads/"+name;
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
