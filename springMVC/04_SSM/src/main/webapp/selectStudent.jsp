<%--
  Created by IntelliJ IDEA.
  User: 胡英亮
  Date: 2022/2/25
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询学生</title>
    <script type="text/javascript" src="jQuery/http_code.jquery.com_jquery-3.3.1.js"></script>

    <script type="text/javascript">
        $(function () {     /*页面加载后执行以下代码*/

            loderInfo();

            $("#buttonToLoadInfo").click(function () {
                loderInfo();
            })
        })


        function loderInfo(){
            $.ajax({
                url:"selectStudent.do",
                type:"get",
                dataType:"json",
                success:function (resp) {
                    /*清除旧数据*/
                    $("#info").html("");
                    /*增加新数据*/
                    $.each(resp,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.email+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }

    </script>
</head>
<body>

    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>NAME</td>
                    <td>EMAIL</td>
                    <td>AGE</td>
                </tr>
            </thead>

            <tbody id="info">


            </tbody>

        </table>

        <input type="button" id="buttonToLoadInfo" value="查询数据">
        <%--&name=xxxvalue=xxxx 对于文本框而言 value就是你的输入 --%>
    </div>

</body>
</html>
