<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="../header.jsp" %>
<%
int count = 1;
String[] oldcheck = (String[])session.getAttribute("checkid[]");
%>
<%-- 絞り込み検索 --%>
<form action="list" method="get">
<div class="siborikomi">
<div class="search-box">
	<span class="search-box_label">表示:</span>
    <input id="sort1" class="radiobutton" name="sort" type="radio" value="new"/>
    <label for="sort1">新着順</label>
    <input id="sort2" class="radiobutton" name="sort" type="radio" value="price" />
    <label for="sort2">価格順</label> 
    <input id="sort3" class="radiobutton" name="sort" type="radio" value="popular" />
    <label for="sort3">人気順</label>
</div>

<div class="search-box">
	<span class="search-box_label">絞り込み:</span>
    <input id="genre1" class="radiobutton" name="genre" type="radio" value="1" />
    <label for="genre1">食事パン</label>
    <input id="genre2" class="radiobutton" name="genre" type="radio" value="2" />
    <label for="genre2">惣菜パン</label> 
    <input id="genre3" class="radiobutton" name="genre" type="radio" value="3" />
    <label for="genre3">菓子パン</label>
</div>

  <div class="search-box">
	<label class="freeword">
	<input type="text" name="keyword" placeholder="キーワードで絞りこむ">
	</label>
  </div>
 <input id="search" type="submit" value="検索">
</div>
</form>
 
<%-- 商品一覧 --%>
<form action="cart" method="post">
<table class="product-list">
    <tr>
		<th colspan="5">商品一覧</th>
	</tr>
<c:forEach var="p" items="${list}">
<% if(count == 1 || count%5==1){ %>
    <tr>
<% } %>
		<td>
		<img src="<%=request.getContextPath()%>/image/product/${p.image}">
		<p>
			<input type="checkbox" id="cartcheck" name="cartcheck" value="${p.id}">			
			<span id="product_name">${p.name}</span>
			<br>
			<span id="product_detail">${p.detail}</span>
			<br>
			${p.price}円
		</p>
		</td>
<% if(count%5==0){ %>
    </tr>
<% } %>
<%
count++;
%>
</c:forEach>
</table>
<input type="submit" id="cart" value="チェックした商品をカートに入れる">
</form>
<%@include file="../footer.jsp" %>