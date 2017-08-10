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
<div class="container">
<xyz:form commandName="prodsuppObject" action="reqAddProdSuppDataToDb">
<div class="col-sm-3" style="background-color: #00ffff;border-radius:15px;padding-bottom:15px;padding-top:5px;">
Products 
<xyz:select path="productid">
<c:forEach var="prd" items="${products}">
<option value="${prd.productid}"> ${prd.productname}</option>
</c:forEach>
</xyz:select>
<br>
Supplier 
<xyz:select path="supplierid">
<c:forEach var="sup" items="${suppliers}">
<option value="${sup.supplierid}"> ${sup.suppliername}</option>
</c:forEach>
</xyz:select>
<br>
Price <xyz:input path="productsupplierprice"/><br>
Stock <xyz:input path="productsupplierstock"/><br>

IsAvailable   <br>
True <xyz:radiobutton path="isproductsupplieravailable" value="true"/><br>
False <xyz:radiobutton path="isproductsupplieravailable" value="false"/><br>

<xyz:button>Add Record</xyz:button>
</div>
</xyz:form>

</div>

</body>
</body>
</html>