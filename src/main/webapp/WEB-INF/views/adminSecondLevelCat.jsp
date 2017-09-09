<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
						Пергого рівня</a></li>
				<li><a href="<c:url value="/admin"/>">Додати категорію
						Другого рівня</a></li>
				<li><a href="#">Додати Доставку</a></li>
				<li><a href="<c:url value="/admin/product"/>">Показати всі
						продукти</a></li>
			</ul>
			<h2></h2>
		</div>
		<div class="center">
			<div class="nameOfTheForm">Форма додавання нових продуктів</div>
			<div class="centerLeft">
				<h3>Створити підкатегорію</h3>
				<form action="createCategorySecondLevel" method="post">
					<input type="text" name="categorySecondLevelName"> <input
						type="submit" value="Створити категорію">
				</form>
				<sf:form modelAttribute="newProduct" action="addNewProduct" method="post">
					<div class="dropDownList">
						<h3>Підкатегорія</h3>
						<sf:select path="categorySecondLevel">
							<c:forEach items="${categorySecondLevel}" var="categorySecond">
								<sf:option value="${categorySecond.getId()}">${categorySecond.categorySecondLevelName}</sf:option>
							</c:forEach>
						</sf:select>
					</div>
					<h3>Назва товару</h3>
					<sf:input path="productName"/>
					<sf:errors path="productName"/>
					<h3>Ціна товару</h3>
					<sf:input path="productPrice"/>
					<sf:errors path="productPrice"/>
					<h3>Виробник товару</h3>
					<sf:select path="makers">
						<c:forEach items="${makers}" var="maker">
							<option value="${maker.getId()}">${maker.getMakerName()}</option>
						</c:forEach>
					</sf:select>
					<br>

					<h3>Посилання на картинку до товару</h3>
					<sf:input path="imageUrl" />
					<sf:errors path="imageUrl"/>
					<h3>Опис товару</h3>
					<sf:textarea path="discription" />
					<sf:errors path="discription"/>
					<p>
						<input type="submit" value="Створити новий товар">
					</p>
				</sf:form>
				<form action="/SybezMarket/admin/createMaker" method="post">
					<h3>Створити нового виробника</h3>
					<input type="text" name="newMaker"> <input type="submit"
						value="Створити нового виробника">
				</form>
			</div>
			<br>

		</div>
	</div>
</body>
</html>
