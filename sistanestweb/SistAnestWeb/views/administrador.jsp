<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>SISTANEST Web - Administrador</title>
		<jsp:include page="meta.jsp"/>
	</head>
	<body>
		<!--CABECERA DE PAGINA -->
		
		<!-- Sidebar on click -->
		<!--<nav class="w3-sidebar w3-bar-block w3-deep-purple w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
			<a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
		    <i class="fa fa-remove"></i>
		  </a>
			<a href="#" class="w3-bar-item w3-button">Link 1</a>
			<a href="#" class="w3-bar-item w3-button">Link 2</a>
			<a href="#" class="w3-bar-item w3-button">Link 3</a>
			<a href="#" class="w3-bar-item w3-button">Link 4</a>
			<a href="#" class="w3-bar-item w3-button">Link 5</a>
		</nav>-->

		<!-- MENU -->
		<div class="w3-top">
			<div class="w3-bar w3-deep-purple w3-left-align">
		  		<a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-teal w3-deep-purple" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
		  		<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">ALTA <i class="fa fa-caret-down"></i></button>     
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">BAJA <i class="fa fa-caret-down"></i></button>     
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">MODIFICAR <i class="fa fa-caret-down"></i></button> 
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">CONSULTAR <i class="fa fa-caret-down"></i></button> 
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">LISTAR <i class="fa fa-caret-down"></i></button>    
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Link</a>
			    	</div>
				</div>
				

		  <!-- MENU EN PANTALLAS PEQUEÑAS -->
		  	<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
			    <a href="#team" class="w3-bar-item w3-button">Team</a>
			    <a href="#work" class="w3-bar-item w3-button">Work</a>
			    <a href="#pricing" class="w3-bar-item w3-button">Price</a>
			    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
			  </div>
		</div>



		<!--PANTALLA PRINCIPAL DEL ADMINISTRADOR -->
		<section class="w3-row-padding w3-padding-64 w3-container ">
			<div class="w3-content w3-text-deep-purple">
				<h1>PAGINA DE ADMINISTRADOR</h1>
				<ol>
					<li style="color: red">hacer servlet del administrador</li>
					<li style="color: red">hacer pie de pagina con mis datos</li>
					<li style="color: red">hacer spa con los contendos del menu</li>
					<li style="color: red">testear</li> 
				</ol>
			
		</section>

		<!--PIE DE PAGINA -->
		<jsp:include page="footer.jsp"/>

		<!-- SCRIPTS QUE VOY A USAR-->
		<jsp:include page="script.jsp"/>
	</body>

	
</html>