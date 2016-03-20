<%--
  Created by IntelliJ IDEA.
  User: annpeter
  Date: 3/19/16
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Demo</title>
    <script type="text/javascript" src="/static/admin/public/javascript/jquery-1.10.2.min.js"></script>
</head>
<body>

<div id="div" style="height: 100px;width: 100px; background-color: #123783"></div>

<script type="text/javascript">
    $(function(){

        $("#div").click(function(){

            var jsObj = {
                "memver_id":"1",
                "jsonShoppingCartModifies":[
                    {"id":1, "num":1},
                    {"id":2, "num":2},
                    {"id":3, "num":3}
                ]
            };

            var str = JSON.stringify(jsObj);

            $.post("http://localhost:8080/app/shoppingcart/modify",{"reqJsonStr":str},
            function(result){
                alert(result);
            });
        });

    });
</script>
</body>
</html>