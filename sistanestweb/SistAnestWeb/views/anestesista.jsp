<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>SISTANEST Web - Anestesista</title>
		<jsp:include page="meta.jsp"/>
	</head>
	<body data-ng-app="Anest" data-ng-controller="cAnest">
		<!--CABECERA DE PAGINA -->
		
		<!-- MENU -->
		<div class="w3-top">
			<div class="w3-bar w3-deep-purple w3-left-align">
		  		<a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-teal w3-deep-purple" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
		  		<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">Empresa <i class="fa fa-caret-down"></i></button>     
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Maternidad Oroño</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Fertya</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Los Alerces</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">Informes <i class="fa fa-caret-down"></i></button>     
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Listar Anestesias ARA</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Listar Anestesias Rendidas</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Listar Anestesias</a>
			    	</div>
				</div>
				<div class="w3-dropdown-hover w3-hide-small">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white">Saldos <i class="fa fa-money fa-lg"></i></button>   
				</div>
				<div class="w3-dropdown-hover w3-hide-small w3-right">
		    		<button class="w3-button w3-hover-teal w3-hover-text-white"><i class="fa fa-user fa-lg"> </i></button> 
			    	<div class="w3-dropdown-content w3-card-4 w3-bar-block" style="right: 0">
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Datos Personales</a>
				      	<a href="#" class="w3-bar-item w3-button w3-hover-teal">Salir <i class="fa fa-sign-out fa-xl"> </i></a>
			    	</div>
				</div>
				
				

			  <!-- MENU EN PANTALLAS PEQUEÑAS -->
			  	<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
				    <a href="#team" class="w3-bar-item w3-button w3-hover-teal">ALTAS</a>
				    <a href="#work" class="w3-bar-item w3-button w3-hover-teal">BAJAS</a>
				    <a href="#pricing" class="w3-bar-item w3-button w3-hover-teal">CONSULTAS</a>
				    <a href="#contact" class="w3-bar-item w3-button w3-hover-teal">LISTADOS</a>
				</div>
			</div>
		</div>

		<!--PANTALLA PRINCIPAL DEL ADMINISTRADOR -->
		<section class="w3-row-padding w3-padding-64 w3-container ">
			<div class="w3-content w3-text-deep-purple">
				<h1>PAGINA DE ANESTESISTA</h1>
				<ol>
					<li style="color: red">hacer servlet del anestesista</li>
					<li style="color: red">hacer spa con los contenidos del menu</li>
					<li style="color: red">testear</li> 
				</ol>

				{{var1 + " " + var2}}
		</section>

		<!--PIE DE PAGINA -->
		<jsp:include page="footer.jsp"/>

		<!-- SCRIPTS QUE VOY A USAR-->
		
		<script src="../angularJS/appanestesista.js"></script>
		<script src="../angularJS/ctrlAnestesista.js"></script>
		<jsp:include page="script.jsp"/>
	</body>

	
</html>