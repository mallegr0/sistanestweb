<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>SISTANEST Web - Administrador</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="styleshhet" href="estilos/w3.css">		
		<style type="text/css">
			body, h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
			.w3-bar,h1,button {font-family: "Monserrat", sans-serif}
		</style>
	</head>
	<body>
		<!--CABECERA DE PAGINA -->
		<!-- Sidebar on click -->
		<nav class="w3-sidebar w3-bar-block w3-deep-purple w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
			<a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
		    <i class="fa fa-remove"></i>
		  </a>
			<a href="#" class="w3-bar-item w3-button">Link 1</a>
			<a href="#" class="w3-bar-item w3-button">Link 2</a>
			<a href="#" class="w3-bar-item w3-button">Link 3</a>
			<a href="#" class="w3-bar-item w3-button">Link 4</a>
			<a href="#" class="w3-bar-item w3-button">Link 5</a>
		</nav>

		<!-- Navbar -->
		<div class="w3-top">
		 <div class="w3-bar w3-deep-purple w3-left-align">
		  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-deep-purple" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
		  <a href="#" class="w3-bar-item w3-button w3-teal"><i class="fa fa-home w3-margin-right"></i>Logo</a>
		  <a href="#team" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Team</a>
		  <a href="#work" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Work</a>
		  <a href="#pricing" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Price</a>
		  <a href="#contact" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
		    <div class="w3-dropdown-hover w3-hide-small">
		    <button class="w3-button" title="Notifications">Dropdown <i class="fa fa-caret-down"></i></button>     
		    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
		      <a href="#" class="w3-bar-item w3-button">Link</a>
		      <a href="#" class="w3-bar-item w3-button">Link</a>
		      <a href="#" class="w3-bar-item w3-button">Link</a>
		    </div>
		  </div>
		  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-teal" title="Search"><i class="fa fa-search"></i></a>
		 </div>

		  <!-- Navbar on small screens -->
		  <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
		    <a href="#team" class="w3-bar-item w3-button">Team</a>
		    <a href="#work" class="w3-bar-item w3-button">Work</a>
		    <a href="#pricing" class="w3-bar-item w3-button">Price</a>
		    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
		    <a href="#" class="w3-bar-item w3-button">Search</a>
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
		<jsp:include page="footer.jsp"></jsp:include>
	</body>

	<script>
// Script for side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "300px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}

// Close side navigation
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>
</html>