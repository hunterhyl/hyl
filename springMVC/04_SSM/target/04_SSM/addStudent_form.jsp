<%--
  Created by IntelliJ IDEA.
  User: 胡英亮
  Date: 2022/2/25
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <form action="addStudent.do" method="post">
            <tr>
                <td>name</td>       <%--这里的name后面的名字 name email age 不是随便写的
                                        因为addStudent.do绑定的方法接收的参数是一个Student 所以要和
                                        Student类中的属性名保持一致才行--%>
                <td><input type="text" name="name"></td>
            </tr>

            <tr>
                <td>email</td>
                <td><input type="text" name="email"></td>
            </tr>

            <tr>
                <td>age</td>
                <td><input type="text" name="age"></td>
            </tr>

            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type="submit" value="zhuce"></td>
            </tr>

        </form>



    </div>


</body>
</html>
