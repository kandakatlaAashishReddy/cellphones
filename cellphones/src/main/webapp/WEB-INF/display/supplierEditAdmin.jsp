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
Edit Supplier Page 
<xyz:form commandName="supplier" action="reqSendUpdatedSupplierToDB">

<xyz:hidden path="supplierid"/>
<br>Supplier Name <xyz:input path="suppliername"/>
<br>Supplier Description <xyz:input path="supplierdesc"/>
<br>Supplier Available  True 
<xyz:radiobutton path="issupplieravailable" value="true"/>  
 False <xyz:radiobutton path="issupplieravailable" value="false"/>
<br> <xyz:button>Update Supplier</xyz:button> 



</xyz:form>
</body>
</html>