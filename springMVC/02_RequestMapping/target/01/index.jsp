<%--
  Created by IntelliJ IDEA.
  User: 胡英亮
  Date: 2022/2/22
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>di yi ge mvc xiang mu</p>
    <p><a href="test/some.do">向some。do发送请求</a> </p>
    <%--这个地址 要和后端的 RequestMapping里面的value一致才行--%>
    <%--a href 方式的请求就是get 方式的请求--%>
<%--    <p><a href="test/other.do">向other.do发送请求</a> </p>--%>

    <form action="test/second.do" method="post">

        <input type="submit" value="tijiao">


    </form>

</body>
</html>
