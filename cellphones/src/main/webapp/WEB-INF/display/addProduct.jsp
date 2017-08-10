<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="adminNavBar.jsp"%>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="col-sm-6"
			style="background-color: #00ffff; border-radius: 30px; padding-bottom: 15px; padding-top: 5px;">
			<div align="center" style="font-size: 30px; color: green">
				<b>Product Details</b>
			</div>
			<xyz:form commandName="productObject" action="reqproductform"
				enctype="multipart/form-data">

				<div class="form-group">
					<b>Enter Product Name</b><br>
					<xyz:input class="form-control" placeholder="Enter Product Name"
						path="productname" />
				</div>


				<div class="form-group">
					<b>Enter Product Description</b><br>
					<xyz:input class="form-control"
						placeholder="Enter Product Description" path="productdesc" />
				</div>

				<div class="form-group">
					<b>Browse file</b><br>
					<xyz:input class="form-control" placeholder="Enter address"
						type="file" path="imagefile" />
				</div>

				<br>
				<xyz:button class="btn btn-primary">check</xyz:button>
			</xyz:form>
		</div>
	</div>
</body>
</html>