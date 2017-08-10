<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminNavBar.jsp" %>
<br><br><br>


<table class="table table-stripped fixed_headers" style="font-weight:bold">
<thead>
<tr >
<th>ProductSupplier Id</th>
<th>Image</th>
<th>ProductSupplier Price</th>
<th>ProductSupplier Stock</th>
<th>Is Available</th>
<th>Options</th>
</tr>
</thead>

<tbody>

<c:forEach var="ps" items="${allxmap}">

<tr>
<td>${ps.psid}</td>
<td><img src="resources/images/ps/${ps.psid}.jpg" class="img-rounded" alt="cinque Terre" height="100px" width="130px" /> </td>
<td>${ps.productsupplierprice}</td>
<td>${ps.productsupplierstock}</td>
<td><a href="reqeditproductsupplierpageAdmin?ps=${ps.psid}">Edit</a> /<a href="reqdeleteproductsupplierAdmin?ps=${ps.psid}"> Delete</a></td>


</tr>

</c:forEach>
</tbody>
</table>

</body>
</html>