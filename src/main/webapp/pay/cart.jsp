<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>
<%
int i = 1;
%>

<form method="post">
<table id="cartlist">
    <tr>
		<th colspan="4">カート一覧</th>
	</tr>
	<c:forEach var="c" items="${cart}">
    <tr>
		<td>
			<img src="<%=request.getContextPath()%>/image/product/${c.image}">
		</td>
		<td>
			<p>
				${c.name}
			</p>
		</td>
		<td>
			<p>
				${c.price}円
			</p>
		</td>
		<td>
			<p>
			<select name="count<%=i %>">
			<c:forEach begin="0" end="10" step="1" varStatus="status">
				<option value="${status.index}">${status.index}</option>
			</c:forEach>
			</select>個</p>
		</td>
    </tr>
	<%
	i++;
	%>
	</c:forEach>
</table>
<input type="submit" class="btn-flat-border bu1" formaction="payment" value="購入する">
</form>
<form method="get">
<input type="submit" class="btn-flat-border bu2" formaction="list" value="買い物を続ける">
</form>

<%@include file="../footer.jsp" %>