<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


	<script>
		// Script para la navegacion lateral
		function w3_open() {
	  		var x = document.getElementById("mySidebar");
	  		x.style.width = "300px";
	  		x.style.paddingTop = "10%";
	  		x.style.display = "block";
		}

		// Cierre de navegacion lateral
		function w3_close() {
	  		document.getElementById("mySidebar").style.display = "none";
		}

		// Se utiliza para alternar el menú en pantallas más pequeñas al hacer clic en el botón del menú
		function openNav() {
	  		var x = document.getElementById("navDemo");
	  		if (x.className.indexOf("w3-show") == -1) {
	    		x.className += " w3-show";
	  		} 
	  		else { 
	    		x.className = x.className.replace(" w3-show", "");
	  		}
		}
	</script>

	<script src="../angularJS/appanestesista.js"></script>
	<script src="../angularJS/ctrlAnestesista.js"></script>

	<script>
		var app = angular.module("appAnest",[]);
		app.controller("ctrlAnest", function($scope){
			$scope.var1 = "a ver si";
			$scope.var2 = "esto funciona";
		});
	</script>