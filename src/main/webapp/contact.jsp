<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    <title>Blog | Contact</title>
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
            <h4>Contact Us</h4>
            <form action="contact" method="post">
                <label>Name</label>
                <input type="text" name="name" required>
                <label>Email</label>
                <input type="email" name="email" required>
                <label>Subject</label>
                <input type="text" name="subject" required>
                <label>Message</label>
                <textarea name="message" id="" cols="30" rows="10"></textarea>
                <button type="submit">Send</button>
            </form>
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

    <section>
        <iframe src="https://www.google.com/maps/embed?pb=!1m26!1m12!1m3!1d28265.5190880317!2d85.31423388699343!3d27.680525449377313!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m11!3e6!4m3!3m2!1d27.6856832!2d85.3475328!4m5!1s0x39eb19ccd083174d%3A0x9dbbf0d3224cf118!2saptechlalitpur!3m2!1d27.670571199999998!2d85.32023079999999!5e0!3m2!1sen!2snp!4v1670517732272!5m2!1sen!2snp" width="100%" height="350" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </section>
</main>
</body>
</html>
