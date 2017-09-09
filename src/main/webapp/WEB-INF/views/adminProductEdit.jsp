<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	background: #F0FFF0;
	font-size: 14px;
	font-family: Verdana;
	text-shadow: 1px 2px 1px #B3B3B3;
}

h3 {
	font-size: 14px;
	font-family: Verdana;
}

.nameOfTheForm {
	margin-top: 3%;
	text-align: center;
	font-size: 22px;
	text-shadow: 1px 2px 16px #CBDFD5;
}

.body {
	width: 100%;
	height: 100%;
	padding: 0.5% 0.5% 0.5% 0.5%;
}

.header {
	width: 99.5%;
	height: 125px;
	border-top: 1px solid green;
	border-bottom: 1px solid green;
	clear: both;
	background: linear-gradient(#C9DED3, rgba(228, 228, 228, 0.17));
}

.leftSide {
	width: 30%;
	height: 70%;
	margin-right: 0.5%;
	margin-top: 0.5%;
	float: left;
}

.center {
	width: 69%;
	height: 70%;
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
	margin-top: 0.5%;
	float: left;
}

.centerLeft {
	width: 69%;
	height: 70%;
	margin-left: 15%;
	margin-top: 2%;
	margin-bottom: 2%;
	padding: 1%;
}

.addingItemsLi {
	line-height: 25px;
	padding: auto;
	text-decoration: #6495ED;
	font-family: Verdana;
	font-weight: 600;
	font-size: 15px;
	list-style-type: none;
}

.addingItemsLi>li>a {
	text-decoration: none;
	border: 1px dotted red;
}

.addingItemsLi>li:hover {
	margin-left: 1%;
}

#formfield {
	width: 250px;
}

input[type=submit] {
	margin-top: 15px;
	padding: 5px 15px;
	background: #CEE2D7;
	border: 1px solid #7E1A8B;
	cursor: pointer;
	font-size: 15px;
	font-weight: 600;
	border-radius: 25px;
}

.dropDownList select {
	background: transparent;
	width: 268px;
	padding: 5px;
	font-size: 15px;
	line-height: 1;
	border: 1px solid black;
	border-radius: 0;
	height: 30px;
}

input[type=text] {
	background: transparent;
	width: 258px;
	padding: 5px;
	font-size: 15px;
	line-height: 1;
	border: 1px solid black;
	border-radius: 0;
	height: 15px;
}

textarea {
	background: transparent;
	padding: 5px;
	text-align: left;
	font-size: 15px;
	border: 1px solid black;
	border-radius: 0;
	height: 45px;
}

.column {
	width: 16%;
	height: 30px;
	border: 1px solid green;
	border-radius: 5px 5px 5px 5px;
	margin-top: 0.5%;
	float: left;
}

.centerAllproducts {
	width: 100%;
	height: 70%;
	margin-top: 2%;
	margin-bottom: 2%;
	padding: 1%;
}
</style>
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="body">
		<div class="header"></div>
		<div class="leftSide">
			<ul class="addingItemsLi">
				<li><a href="<c:url value="/admin"/>">Додати категорію
						Першого рівня</a></li>
				<li><a href="<c:url value="/admin"/>">Додати категорію
						Другого рівня</a></li>
				<li><a href="#">Додати Доставку</a></li>
				<li><a href="<c:url value="/admin/product"/>">Показати всі
						продукти</a></li>
			</ul>
			<h2></h2>
		</div>
		<div class="center">
			<div class="nameOfTheForm">Редагування товару</div>
			<div class="centerAllproducts">
				<div class="centerLeft">Підкатегорія:
					${productForEdit.getCategorySecondLevel().getCategorySecondLevelName()}</div>

				<sf:form modelAttribute="productForEdit" action="edit" method="post">
					<sf:select path="categorySecondLevel">
						<c:forEach items="${categorySecondLevel}" var="categorySecond">
							<option value="${categorySecond.getId()}">${categorySecond.categorySecondLevelName}</option>
						</c:forEach>
					</sf:select>
					<div class="centerLeft">Назва
						товару:${productForEdit.getProductName()}</div>
					<sf:input path="productName" />
					<sf:errors path="productName"/>
					<div class="centerLeft">Ціна: ${productForEdit.getProductPrice()}
						${config.getCurrencyName()}</div>
					<sf:input path="productPrice" />
					<sf:errors path="productPrice"/>
					<div class="centerLeft">Виробник:
						<c:forEach items="${productForEdit.makers}" var="maker">
							<option>${maker.getMakerName()}</option>
						</c:forEach>
						</div>
					<sf:select path="makers">
						<c:forEach items="${makers}" var="maker">
							<option value="${maker.getId()}">${maker.makerName}</option>
						</c:forEach>
					</sf:select>
					<div class="centerLeft">Опис: ${productForEdit.getDiscription()}</div>
					<sf:input path="discription" />
					<sf:errors path="discription"/>
					<div class="centerLeft">Картинка: ${productForEdit.getImageUrl()}</div>
					<sf:input path="imageUrl" />
					<sf:errors path="imageUrl"/>

					<input type="submit" value="Підтвердити" />

				</sf:form>
			</div>
		</div>
	</div>
</body>
</html>