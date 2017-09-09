<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 40px;
}
</style>
<body>

	<h3>Using CSS to style a HTML Form</h3>

	<div>
		<h1>Категорія першого рівня</h1>
		<p>
		<form action="admin/categoryFirstLevel" method="post">
			<select id="categoriesFirstLevel" name="categoriesFirstLevel">
				<c:forEach items="${categoryFirstLevel}" var="categoryFirstLevel">
					<option value="${categoryFirstLevel.getId()}">${categoryFirstLevel.getCategoryFirstLevelName()}</option>
				</c:forEach>
			</select>
			<p>
				<input type="submit" value="Вибрати категорію">
			</p>
		</form>

		<h1>Створити категорію першого рівня</h1>

		<form action="admin/createCategoryFirstLevel" method="post">
			<p>
				<input type="text" name="categoryFirstLevelName">
			</p>
			<p>
				<input type="submit" value="Створити категорію">
			</p>
		</form>
		<h1>Категорія другого рівня</h1>
		<form action="admin/newProduct" method="post">
			<select id="categoriesSecondLevel" name="categoriesSecondLevel">
				<c:forEach items="${categoriesSecondLevel}"
					var="categoriesSecondLevel">
					<option value="${categoriesSecondLevel.getId()}">${categoriesSecondLevel.getCategorySecondLevelName()}</option>
				</c:forEach>
			</select>
			<p>
				<input type="submit" value="Вибрати категорію">
		</form>
		<h1>Створити категорію другого рівня</h1>

		<form action="admin/createCategorySecondLevel" method="post">
			<p>
				<input type="text" name="categoryFirstLevelName">
			</p>
			<p>
				<input type="submit" value="Створити категорію">
			</p>
	</div>

</body>
</html>