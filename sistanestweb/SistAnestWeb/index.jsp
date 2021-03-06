<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>SISTANEST Web</title>
		<jsp:include page="/views/meta.jsp"/>
	</head>
	<body>
		<!--CABECERA DE PAGINA -->
		<header class="w3-container w3-deep-purple w3-center" style="padding: 32px 16px">
			<h1 class="w3-margin w3-xxxlarge">SISTANEST Web</h1>
		</header>

		<!--FORM DEL LOGIN -->
		<section class="w3-row-padding w3-padding-64 w3-container ">
			<div class="w3-content w3-text-deep-purple">
				<h1>HAY VERSIONADO, REVISAR Y COMPLETAR</h1>
				
			<!-- Formulario-->
			<div class="w3-quarter w3-container"></div>
			<form action="Login" id="Login" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-deep-purple w3-margin w3-half">
				<div class="w3-row w3-section">
					<div class="w3-col" style="width: 50px"><i class="w3-xxlarge fa fa-user"></i></div>
					<div class="w3-rest"><input  class="w3-input w3-border" type="text" name="usuario" placeholder="Usuario"></div>
				</div>
				<div class="w3-row w3-section">
					<div class="w3-col" style="width: 50px"><i class="w3-xxlarge fa fa-key"></i></div>
					<div class="w3-rest"><input  class="w3-input w3-border" type="password" name="password" placeholder="Contraseña"></div>
				</div>
				
				<button class="w3-btn w3-block w3-section w3-deep-purple w3-ripple w3-padding w3-hover-teal">Ingresar</button>
			</form>
			<div class="w3-quarter w3-container"></div>
		</section>

		<!--PIE DE PAGINA -->
		<jsp:include page="/views/footer.jsp"/>
	</body>
</html>