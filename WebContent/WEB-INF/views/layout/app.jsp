<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <title>いいこと日記</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">

<link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/popper.js/1.14.1/popper.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/index" />">
    <input type="image" src="/iikoto_diary/images/logo.png" ></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
            月別いいことページリンク
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
            <c:forEach var="month" items="${month}" varStatus="status">
            <form method="GET" class="dropdown-item" action="<c:url value="/month" />" class="dropdown-item">
            <a href="<c:url value='/month?mon=${month.createMonth}&year=${month.createYear}' />">
             <fmt:formatDate value='${month.createDate}' pattern='yyyy-MM' /></a></form>
            </c:forEach>
            </li>
          </ul>
        </li>
      </ul>
          </div>
  </div>
</nav>

            <div id="content">
                ${param.content}
            </div>
            <div id="footer" class="fixed-bottom">
                by UMUM-MYK.
            </div>

</html>