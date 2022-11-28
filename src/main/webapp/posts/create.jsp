<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>

<form action="post-create" method="post">
    <label>Title</label>
    <input type="text" name="title" required>

    <label>Content</label>
    <textarea name="content" id="" cols="30" rows="10"></textarea>

    <label>Picture</label>
    <button>Set Picture</button>

    <button type="submit">Create Post</button>
</form>
</body>
</html>
