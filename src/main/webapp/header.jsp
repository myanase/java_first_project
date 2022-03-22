<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sunny Bread</title>
<style><%@include file="./css/header.css"%></style>
</head>
<body>
<header class="header">
    <h1>
        <a href="/">Sunny Bread</a>
    </h1>
    <nav class="pc-nav">
        <ul>
            <li><a href="#"><img src="<%=request.getContextPath()%>/image/cart.png"></a></li>
            <li><a href="#"><img src="<%=request.getContextPath()%>/image/mypage.png"></a></li>
        </ul>
    </nav>
</header>
<div class="deco"><img src="<%=request.getContextPath()%>/image/star.png"></div>