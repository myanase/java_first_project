<div class="theme">
	<span class="star">★</span>注文内容
</div>
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
	単価：${c.price}円×${cartmap.get(${c.id})}個
	</p>
	</td>
	<td>
	<p>
	<select name="count${c.id}">
<c:forEach begin="0" end="10" step="1" varStatus="status">
<option value="${status.index}">${status.index}</option>
</c:forEach>
</select>個</p>
</td>
    </tr>
</c:forEach>