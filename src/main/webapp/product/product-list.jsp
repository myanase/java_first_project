<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>

<%
int count = 1;
%>
<table class="product-list">
    <tr>
		<th colspan="5">商品一覧</th>
	</tr>
<c:forEach var="p" items="${list}">
<% if(count == 1 || count%5==1){ %>
    <tr>
<% } %>
		<td><a href="#"><img src="<%=request.getContextPath()%>/image/product/${p.image}"></a>
		<br>
		<p>${p.name}<br>${p.price}円</p></td>
<% if(count%5==0){ %>
    </tr>
<% } %>
<%
count++;
%>
</c:forEach>
</table>

<%@include file="../footer.jsp" %>
