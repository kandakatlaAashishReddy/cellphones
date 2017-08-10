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
Edit Product Page 
<xyz:form commandName="product" action="reqSendUpdatedProductToDB">

<xyz:hidden path="productid"/>
<br>Product Name <xyz:input path="productname"/>
<br>Product Description <xyz:input path="productdesc"/>
<br>Product ISAvailable True <xyz:radiobutton path="isproductavailable" value="true"/>  
 False <xyz:radiobutton path="isproductavailable" value="false"/>
<br> 
 <xyz:button>Update Product</xyz:button> 



</xyz:form>
</body>
</html>