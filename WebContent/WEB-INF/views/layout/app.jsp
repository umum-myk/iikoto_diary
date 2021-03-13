<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <title>いいこと日記</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">

<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Mayuka Ui.
            </div>
</body>
</html>