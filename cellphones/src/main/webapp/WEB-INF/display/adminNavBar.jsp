<nav class="container navbar navbar-inverse  navbar-fixed-top" style="border-radius:10px;margin-bottom:0;padding-bottom:0px">
	<div class="container">
	
	
	
		<ul class="nav navbar-nav" >
			<li><img src="resources/images/customer/CST00000${customerprofile.customerid}.jpg" height="50"
				width="60" class="img-circle" /></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Welcome ${username}<span
					class="caret"></span></a>
				<ul class="dropdown-menu" style="vertical-align: middle">
					<li><a href="#">Edit Profile</a></li>
					<li><a href="#">Change Password</a></li>
					<li><a href="reqLogout">Logout</a></li>
				</ul>
			</li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Products<span class="caret"
					style="vertical-align: middle"></span></a>
				<ul class="dropdown-menu">
					<li><a href="reqDisplayProductsAdmin"><span
							class="glyphicon glyphicon-list"></span> Display All products</a></li>
					<li><a href="reqProductForm">Add Product</a></li>
				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Suppliers<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="reqDisplaySuppliers">Display All suppliers</a></li>
					<li><a href="reqAddSupplierForm">Add Supplier</a></li>
				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">ProductSupplier<span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="reqDisplayXps">Display All ProductSuppliers</a></li>
					<li><a href="reqAddProdSuppForm">Add ProductSupplier</a></li>
				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Users<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="reqDisplayUsers">Display Users</a></li>
				</ul></li>
		</ul>	
	
	</div>
</nav>