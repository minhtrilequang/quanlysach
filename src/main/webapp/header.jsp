<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">

		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="trangchu">Trang chu</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Danh mục<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${dsloai}" var="o">
							<li><a href="loai?ml=${o.maloai}">${o.tenloai}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="giohang.jsp">Giỏ hàng</a></li>
				<li><a href="thanhtoan.jsp">Thanh toán</a></li>
				<li><a href="lichsumuahang">Lịch sử mua hàng</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.dn==null}">
					<li><a href="dangnhap.jsp"><span
							class="glyphicon glyphicon-user"></span>Đăng nhập</a></li>
					<li><a href="dangky.jsp">Đăng ký</a></li>
				</c:if>

				<c:if test="${sessionScope.dn!=null}">
					<li><a href="">Xin chào <c:out value="${sessionScope.dn.getHoten()}" /></a></li>
					<li><a href="dangxuat"><span
							class="glyphicon glyphicon-log-in"></span>Đăng xuất</a></li>
				</c:if>



			</ul>
		</div>
	</nav>
</body>
</html>