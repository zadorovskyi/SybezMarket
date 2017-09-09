<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="body">
		<div class="header"></div>
		<div class="leftSide">
			<ul class="addingItemsLi">
				<li><a href="#">Додати категорію Пергого рівня</a></li>
				<li><a href="#">Додати категорію Другого рівня</a></li>
				<li><a href="#">Додати Доставку</a></li>
				<li><a href="#">Додати Продукти</a></li>
			</ul>
			<h2></h2>
		</div>
		<div class="center">
			<div class="nameOfTheForm">Форма додавання нових продуктів</div>
			</p>
			<div class="centerLeft">
				<form form="form1">
					<div class="dropDownList">
						<h3>Категорія першого рівня</h3>
						<select name="categoryFirstName">
							<option value="volvo">Volvo</option>
						</select><br>
					</div>
					<div class="dropDownList">
						<h3>Категорія другого рівня</h3>
						<select name="categorySecondName">
							<option value="volvo">Vevo</option>
						</select>
					</div>
					<h3>Назва продукту</h3>
					<input type="text" name="productName">
					<h3>Опис продукту</h3>
					<textarea placeholder="Remember, be nice!" rows="4" cols="50"
						name="productDisription">
					</textarea>
				</form>
				<br>
				<form action="admin/addNewProduct" method="post" id="form1"
					enctype="multipart/form-data">
					ЗАвантаження фотографії <input type="file" name="file"><br />
					<input type="submit" value="Добавити продукт">
				</form>



			</div>
		</div>
	</div>
</body>
</html>
