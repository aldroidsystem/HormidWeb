<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0.1 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Harga List</title>
</head>
<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>Harga ID</td>
					<td>Tanggal Mulai</td>
					<td>Harga Beli</td>
					<td>Harga Jual</td>
					<td>Created By</td>
					<td>Created Date</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${harga}" var="price">
			<tr>
				<td>${price.getHargaId()}</td>
				<td>${price.getTanggalMulai()}</td>
				<td>${price.getHargaBeli()}</td>
				<td>${price.getHargaJual()}</td>
				<td>${price.getCreatedBy()}</td>
				<td>${price.getCreatedDate()}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</div>
</body>

</html>