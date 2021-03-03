<%--
  Created by IntelliJ IDEA.
  User: 一个帅帅哒男神
  Date: 2021/2/19
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>




    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${books.bookID}">

        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${books.bookName}" id="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCount">书籍数量</label>
            <input type="text" name="bookCount" class="form-control" value="${books.bookCount}" id="bookCount" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${books.detail}" id="detail" required>
        </div>


        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>


</body>
</html>
