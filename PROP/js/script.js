 var vHistorial = false;
 var username = "";
 var isAdmin = false;

 function afterLoading() {
 	$("#loading_container").fadeOut(0);
 	$("#authory").fadeOut(0);
 	$("#logo_container").animate({
 		"margin-top": "1em"
 	}, 1500);
 	$("#logo_container img").animate({
 		"width": "100px",
 		"height": "100px"
 	}, 1500);
 	$("#logo_container h3").animate({
 		"font-size": "1.5em"
 	}, 1500, function() {
 		$("#signin").fadeIn(500);
 	});
 }

 function carrega() {
 	if(window.java.CreaGraf()) {
 		afterLoading();
 	}
 	else Materialize.toast("NO XUTA",2000);

 }

 function consulta() {
 	switch($("#tipus_cerca").val()) {
 		case "0":

 		case "1":

 		case "2":

 		case "3":

 		case "4":
 	}
 }

$(document).ready(function() {
	setTimeout(carrega,500);

    $('ul.tabs').tabs('select_tab', 'login');

     $("#registerform_submit").on("click", function(e) {
     	if (window.java.Registrarse($("#registerform_user").val(),$("#registerform_pass").val(),$("#registerform_pass2").val())) {
		 	Materialize.toast('Registre efectuat correctament', 4000);
		 	$("#loginform_user").val($("#registerform_user").val());
		 	$("#loginform_pass").val($("#registerform_pass").val());
		 	$('ul.tabs').tabs('select_tab', 'login');
		 	Materialize.updateTextFields();
		 }
		 else Materialize.toast("Error en el registre, torna-ho a provar.",2000);
 	 });
 	 $("#loginform_submit").on("click", function(e) {
 	 	if (window.java.ExisteixUsuari_contrasenya($("#loginform_user").val(),$("#loginform_pass").val())) {
 	 		username = $("#loginform_user").val();
 	 		Materialize.toast('Accedint al teu compte...', 2000);
	 		$("#logo_container").fadeOut(1000);
	 		$("#logo_container h3").fadeOut(1000);
	 		$("#logo_container img").fadeOut(1000);
	 		$("#signin").fadeOut(1000);
	 		$('select').material_select();
	 		setTimeout(function() { $("#homepage").fadeIn(1000); $("#nomusuariContainer").text(username); }, 1000);
 	 	}
 	 	else Materialize.toast("Login Incorrecte",2000);
	 	
 	 });
 	 $("#adminform_submit").on("click", function(e) {
 	 	if ($("#adminform_user").val() == "Administrador" && $("#adminform_pass").val() == "1234") {
 	 		username = $("#adminform_user").val();
 	 		isAdmin = true;
 	 		Materialize.toast('Accedint al teu compte...', 2000);
	 		$("#logo_container").fadeOut(1000);
	 		$("#logo_container h3").fadeOut(1000);
	 		$("#logo_container img").fadeOut(1000);
	 		$("#signin").fadeOut(1000);
	 		$('select').material_select();
	 		setTimeout(function() { 
	 			$("#homepage").fadeIn(1000); 
	 			$("#nomusuariContainer").text(username); 
	 			$("#opcions_admin").css({ "display": "block" });
	 		}, 1000);
 	 	}
 	 	else Materialize.toast("Login Incorrecte",2000);
 	 });
 	 $("#historial_button").on("click", function(e) {
 	 	if(vHistorial) {
 	 		$("#historial").animate({
 	 			"height": "0px"
 	 		}, 1000, function() { $("#historial").fadeOut(0); });
 	 	} else {
 	 		$("#historial").fadeIn(0);
 	 		$("#historial").animate({
 	 			"height": "800px"
 	 		});
 	 	}
 	 	vHistorial = !vHistorial;
 	 });
 	 $("#tancabutton").on("click",function(e) {
 	 	username = "";
 	 	isAdmin = false;
 	 	$("#opcions_admin").css({ "display": "none" });
 	 	$("#homepage").fadeOut(1000);
	 	setTimeout(function() { 
	 		$("#logo_container").fadeIn(1000);
	 		$("#logo_container h3").fadeIn(1000);
	 		$("#logo_container img").fadeIn(1000);
	 		$("#signin").fadeIn(1000); 
	 	}, 1000);
 	 });

 	 $("#search").bind("enterKey",function(e) {
 	 	consulta();
 	 });
 	 $("#search").keyup(function(e) {
 	 	if(e.keyCode == 13) {
 	 		$(this).trigger("enterKey");
 	 	}
 	 });

 	 $('.modal-trigger').leanModal();

 });