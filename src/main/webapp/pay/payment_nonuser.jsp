<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>

<form action="payment-confirm" method="post" id="cc-form" autocomplete="off">
	<div class="wrapper">
	    <div class="container">
            <h1>
                お客様情報入力
            </h1>
                <div class="theme">
                    <span class="star">★</span>個人情報
                </div>
                <div>
                    <label for="name">お名前</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="例：山田太郎" autofocus required>
                </div>
                <div>
                    <label for="email">メールアドレス</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="例：test@test.com" required>
                </div>
                <div>
                    <label for="tel">電話番号</label>
                    <input type="tel" id="tel" name="tel" class="form-control" placeholder="例：08012345678" required>
                </div>
                <div>
                    <label for="address1">住所</label>
                    <input type="text" id="address1" name="address1" class="form-control" required>
                </div>

                <div class="theme">
                    <span class="star">★</span>お届け先情報
                </div>
                <div class="address">
                <input type="radio" name="orderaddress" value="address1" checked>住所と同一
                <br>
                <input type="radio" name="orderaddress" value="address2">
                <input type="text" id="address2" name="address2" class="form-control">
                </div>
            
                <div class="theme">
                    <span class="star">★</span>支払情報
                </div>
                <div class="group card-number">
                    <label for="first">カード番号</label>
					<input type="text" name="cardnum1" id="first" class="cc-num" type="text" maxlength="4" size="4" placeholder="&#9679;&#9679;&#9679;&#9679;">
					<input type="text" name="cardnum2" id="second" class="cc-num" type="text" maxlength="4" size="4" placeholder="&#9679;&#9679;&#9679;&#9679;">
					<input type="text" name="cardnum3" id="third" class="cc-num" type="text" maxlength="4" size="4" placeholder="&#9679;&#9679;&#9679;&#9679;">
					<input type="text" name="cardnum4" id="fourth" class="cc-num" type="text" maxlength="4" size="4" placeholder="&#9679;&#9679;&#9679;&#9679;">
                </div>
                <div class="group card-name">
                    <label for="name">カード名</label>
                    <input type="text" id="name" name="cardname" type="text" maxlength="20" placeholder="TARO YAMADA">
                </div>
                <div class="group card-expiry">
                    <div class="input-item expiry">
                        <label for="expiry">有効期限</label>
                        <input type="text" name="expirymm" class="month" id="expiry" placeholder="02" size="2">
                        <input type="text" name="expiryyyy" class="year" placeholder="2017" size="4">
                    </div>
                    <div class="input-item csv">
                        <label for="csv">CSV No.</label>
                        <input type="text" name="csvno" class="csv" size="3" placeholder="010">
                    </div>
                </div>
				<%@include file="cart_confirm.jsp" %>
                <div>
                    <span class="arrow"></span>
                    <input type="submit" class="submit" value="内容確認へ進む">
                </div>
          </div>
    </div>
</form>
<%@include file="../footer.jsp" %>