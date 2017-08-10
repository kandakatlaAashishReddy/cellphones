<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="xyz"%>
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbarBeforlogin.jsp"%>
	<div class="container">
		<div class="col-sm-6"
			style="background-color: #00ffff; border-radius: 30px; padding-bottom: 15px; padding-top: 5px;">
			<div align="center" style="font-size: 30px; color: green">
				<b>SignUP</b>
			</div>

			<xyz:form commandName="customerObject" action="reqSendSignupData"
				enctype="multipart/form-data">

				<div class="form-group">
					<b>Enter Customer name</b><br>
					<xyz:input class="form-control" placeholder="Enter Name"
						path="customername" />
				</div>


				<div class="form-group">
					<b>Enter email ID</b><br>
					<xyz:input class="form-control" placeholder="Enter email ID"
						path="mailid" />
				</div>

				<div class="form-group">
					<b>Enter mobile number</b><br>
					<xyz:input class="form-control" placeholder="Enter mobile Number"
						path="mobileno" />
				</div>
				<div class="form-group">
					<b>Browse file</b><br>
					<xyz:input class="form-control" placeholder="Enter address"
						type="file" path="customerImage" />
				</div>
				<div class="form-group">
					<b>Enter password </b><br>
					<xyz:password class="form-control" placeholder="Enter Password"
						path="userDetails.password" />
				</div>




				<div class="form-group">
					<b>Enter Shipping Address</b><br>
					<xyz:input class="form-control"
						placeholder="Enter Shipping Address"
						path="shippingAddress.houseno" />
				</div>

				<div class="form-group">
					<b>Enter Street</b><br>
					<xyz:input class="form-control" placeholder="Enter Street no"
						path="shippingAddress.street" />
				</div>

				<div class="form-group">
					<b>Enter Address Area</b><br>
					<xyz:input class="form-control" placeholder="Enter Address Area"
						path="shippingAddress.area" />
				</div>

				<div class="form-group">
					<b>City</b> <br>
					<xyz:input class="form-control" placeholder="Enter City"
						path="shippingAddress.city" />
				</div>

				<div class="form-group">
					<b>State</b> <br>
					<xyz:input class="form-control" placeholder="Enter State"
						path="shippingAddress.state" />
				</div>

				<div class="form-group">
					<b>Country</b> <br>
					<xyz:input class="form-control" placeholder="Enter Country"
						path="shippingAddress.country" />
				</div>

				<div class="form-group">
					<b>Pin code</b> <br>
					<xyz:input class="form-control" placeholder="Enter Pincode"
						path="shippingAddress.pincode" />
				</div>

				<div align="right">
					<xyz:button class="btn btn-primary">SignUp</xyz:button>
				</div>


			</xyz:form>
		</div>

		<div class="col-sm-6">

			<img src="resources/images/products/PRD00014.jpg" height="250px"
				width="100%" /> <br>
		</div>
	</div>
</body>
</html>