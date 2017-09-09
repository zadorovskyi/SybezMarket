<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8" />
    <title></title>
<style>
.header{
width: 99.5%;
	height: 125px;
	border-top: 1px solid green;
	border-bottom: 1px solid green;
	clear: both;
	background: linear-gradient(#C9DED3, rgba(228, 228, 228, 0.17));
}
.left{
	width: 30%;
	height: 800px;
	margin-right: 0.5%;
	margin-top: 0.5%;
	float: left;
	border:1px solid green;
}
.main {
	width: 67%;
	height: 800px;
	border: 1px solid green;
	margin-top: 0.5%;
	padding:1%;
	float: left;
}
.product{
width: 95%;
	height: 200px;
	border: 1px solid green;
	margin: 0.5%;
	padding:1%;
	float: left;
}
.productImage{
	width: 180px;
	height: 180px;
	border: 1px solid green;
	margin-top: 0.5%;
	padding:0.1%;
	float: left;
}
.productDiscriptionTitle{
	width: 75%;
	height: 50px;
	float: left;
	font-size:18px;
    font-weight: 700;
    text-align: center;
}
.buyingButtonAndPrice{
	width: 20%;
	height: 100%;
		float: left;
}
.productPrice{
    width: 92%;
    height: 54px;

	float: left;
	text-align: center;
    padding-top: 13px;
    font-size: 21px;
    font-style: italic;
    font-weight: 800;
    border: 1px solid;
    border-radius: 25px;
    margin-left: 10px;
}
.currency{
    font-size: 16px;
    font-weight: 500;
}
.productBuyingButton{
	width: 120px;
	height: 60px;
	margin:8px;
	border:1px solid green;
	float: left;
	box-shadow:5px 8px 28px -2px rgb(177, 181, 177);
}
.productBuyingButton{
    width: 127px;
    height: 41px;
    margin-left: 11px;
    margin-top: 10px;
    float: left;
    font-size: 22px;
    text-align: center;
    padding: 9px;
    font-weight: 600;
    border-radius: 20px;
}
.productDiscription{
	width:427px;
	margin:8px;
	float: left;
}
.productBuyingButton:hover{
box-shadow: inset 5px 8px 28px -2px rgb(177, 181, 177);
}



</style>
</head>
<body>
<div class="header"></div>
<div class="left"></div>
<div class="main">
	<c:forEach items="${products}" var="product">
	<div class="product">
		<div class="productImage"><img height="180px" width="180px" src="${product.getImageUrl()}"></div>
		<div class="productDiscriptionBlock">
			<div class="productDiscriptionTitle">${product.getProductName()}</div>
			<div class="buyingButtonAndPrice">
				<div class="productPrice">${product.getProductPrice()}<div class="currency">${currency.getCurrencyName()}</div></div>
				<c:url value="product/${product.getId()}" var="button"/>
				<a href="${button}"><div class="productBuyingButton">Купити</div></a>
			</div>
			<div class="productDiscription">${product.getDiscription()}</div>
		</div>
	</div>
	</c:forEach>

</div>
<div class="footer"></div>

</body>