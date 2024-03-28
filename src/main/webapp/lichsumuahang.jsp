<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<table class="table">
	<tr>
		<td><b>Mã sách</b></td>
		<td><b>Tên sách</b></td>
		<td><b>Số lượng</b></td>
		<td><b>Thành tiền</b></td>
		<td><b>Ngày mua</b></td>
		
	</tr>
	<c:forEach items="${ds}" var="o">
		<tr>
			<td>${o.masach}</td> 
			<td>${o.tensach}</td>
			<td>${o.soluong}</td>
			<td>${o.thanhtien}</td>
			<td>${o.ngaymua}</td>
			
		</tr>
	</c:forEach>
</table>
	
	
</body>
</html>