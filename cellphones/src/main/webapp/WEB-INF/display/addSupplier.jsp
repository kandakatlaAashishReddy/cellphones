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
				<b>Supplier Details</b>
			</div>
			<xyz:form commandName="supplierObject" action="reqsupplierform"
				enctype="multipart/form-data">

				<div class="form-group">
					<b>Enter Supplier Name</b><br>
					<xyz:input class="form-control" placeholder="Enter Supplier Name"
						path="suppliername" />
				</div>


				<div class="form-group">
					<b>Enter Supplier Description</b><br>
					<xyz:input class="form-control"
						placeholder="Enter Supplier Description" path="supplierdesc" />
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