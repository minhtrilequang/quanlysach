<%@page import="bean.giohangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gio hang</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	


<div class="container">
	<%giohangbo gioHang = (giohangbo) session.getAttribute("gh");
	ArrayList<giohangbean> danhSachSanPham = gioHang.getDS();%>
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
            <form action="suaxoa" method="get">
                <thead>
                    <tr>
                        <th> Sách</th>
                        <th>Số lượng</th>
                        <th class="text-center">Giá</th>
                        <th class="text-center">Tổng cộng</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                
                    <c:forEach items="<%=danhSachSanPham%>" var="o">
                    	<tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                        	<input type="checkbox" name="boxsach" value="${o.masach}" >
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${o.anh}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${o.tensach}</a></h4>
                                <h5 class="media-heading"> by <a href="#">${o.tacgia}</a></h5>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="text" class="form-control"  value="${o.soluong}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${o.gia}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${o.thanhtien}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <a href="suaxoa?masach=${o.masach}"><button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Xóa
                        </button></td></a>
                        
                    </tr>
                    </c:forEach>
                  
                </tbody>
                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><input type="submit" value="Xóa đã chọn"></td>
                        
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="suaxoa?masach=hellokitty"><button type="button" class="btn btn-default">
                            Xóa tất cả
                        </button></a>
                        </td>
                        <td>
                        <a href="thanhtoan">
                        	<button type="button" class="btn btn-success">
	                            Thanh toán
	                        </button></td>
                        </a>
                        
                    </tr>
                </tfoot>
                </form> 
            </table>
        </div>
    </div>
</div>
</body>
</html>