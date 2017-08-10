<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script >
$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});
</script>
</head>
<body>
<%@ include file="adminNavBar.jsp" %>
<br><br> <br><c:if test="${productmessage!=null}">
	<div class="container">
    
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
     <div class="alert alert-success alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${productmessage}
    </div>
  </div>
  </div>
  </c:if>

<div class="container">

<table class="table table-stripped fixed_headers" style="font-weight:bold;background-color:green" >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center" bgcolor="#ff0000">Product Id</th>
<th style="text-align:center" bgcolor="#ff0000">Image</th>
<th style="text-align:center" bgcolor="#ff0000">Product Name</th>
<th style="text-align:center" bgcolor="#ff0000">Product Description</th>
<th style="text-align:center" bgcolor="#ff0000">Is Available</th>
<th style="text-align:center" bgcolor="#ff0000">Options</th>
</tr>
</thead>

<tbody>

<c:forEach var="p" items="${allproducts}">

<tr>
<td style="text-align:center;vertical-align: middle;">${p.productid}</td>
<td style="text-align:center;vertical-align: middle;"><img src="resources/images/products/${p.productid}.jpg" height="100px" width="130px" /> </td>
<td style="text-align:center;vertical-align: middle;">${p.productname}</td>
<td style="text-align:center;vertical-align: middle;">${p.productdesc}</td>
<td style="text-align:center;vertical-align: middle;">${p.isproductavailable}</td>
<td style="text-align:center;vertical-align: middle;">
<a href="reqEditProductPageAdmin?pid=${p.productid}">
<span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
</a> / 
<a href="reqDeleteProductAdmin?pid=${p.productid}">
<span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
</a>
</td>


</tr>

</c:forEach>
</tbody>
</table>
</div>

</body>
</html>