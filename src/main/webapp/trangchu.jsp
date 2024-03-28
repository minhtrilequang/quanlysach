<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<c:forEach items="${dssach}" var="o">

			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-body" style="height: 290px">
						<img style="height: 260px" alt="" src="${o.anh}">
					</div>
					<div class="panel-footer" style="height: 120px">
						<h4>${o.tensach}</h4>
						<h3>${o.gia} <a href="giohang?ms=${o.masach}&ts=${o.tensach}&tg=${o.tacgia}&gia=${o.gia}&anh=${o.anh}">Mua ngay</a></h3>
						
					</div>
				</div>

			</div>

		</c:forEach>
	</div>
	
	<c:forEach begin="1" end="${endpage}" var="i">
		<ul class="pagination">
		  <li><a href="trangchu?index=${i}">${i}</a></li>
		
		</ul>
	</c:forEach>
</body>
</html>