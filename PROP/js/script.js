 var vHistorial = false;
 var username = "";
 var password = "";
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
 	else Materialize.toast("No es crea el Graf.",2000);

 }

 function consulta() {
 	$("#collapsibleConsulta li").css({ "display": "none" });
    var perfil = JSON.parse(window.java.consulta($("#Tipus_Node").val(),$("#search").val(),parseInt($("#rangeAutors").val()),parseInt($("#rangeTermes").val()),parseInt($("#rangeConferencies").val()),parseInt($("#rangeArticles").val()),(username != "")));
 	var tipus = $("#Tipus_Node").val();
 	if (tipus == "General") {
 		if(window.java.existeixnode($("#search").val(),"Autor")) tipus = "Autor";
 		else if (window.java.existeixnode($("#search").val(),"Conferencia")) tipus = "Conferencia";
 		else if (window.java.existeixnode($("#search").val(),"Terme")) tipus = "Terme";
 		else if (window.java.existeixnode($("#search").val(),"Article")) tipus = "Article";
 	}
 	$("#collapsibleConsulta").html("");
 	if (perfil != "No s'ha trobat") {
 		setConsultaHistorial($("#search").val(),tipus);
 	}
 	if (tipus == "Autor") {
 		$("#collapsibleArticles").css({ "display" : "block" });
 		$("#collapsibleConferencies").css({ "display" : "block" });
 		$("#collapsibleCoautors").css({ "display" : "block" });
 		$("#collapsibleTermes").css({ "display" : "block" });
	}

	if (tipus == "Article") {
 		$("#collapsibleConferencies").css({ "display" : "block" });
 		$("#collapsibleAutors").css({ "display" : "block" });
 		$("#collapsibleTermes").css({ "display" : "block" });
	}

	if (tipus == "Conferencia") {
		$("#collapsibleArticles").css({ "display" : "block" });
 		$("#collapsibleAutors").css({ "display" : "block" });
 		$("#collapsibleTermes").css({ "display" : "block" });
	}

	if (tipus == "Terme") {
		$("#collapsibleArticles").css({ "display" : "block" });
 		$("#collapsibleConferencies").css({ "display" : "block" });
 		$("#collapsibleAutors").css({ "display" : "block" });
	}

	$("#collapsibleConsulta").collapsible({  accordion: false  });
 }

 function getHistorial() {
     var hist = JSON.parse(window.java.historial_get());

     $("#historial .collection").html("");
     hist.forEach(function(elem, i) {
     	$("#historial .collection").append("<li class='collection-item'>" + elem + "<a href='#!' class='secondary-content' onclick='borrarElementHistorial(" + i + ")'><i class='material-icons'>delete</i></a></li>");
     });
 }

 function borrarElementHistorial(n) {
     window.java.historial_remove(n);
     getHistorial();
 }

 function setConsultaHistorial(nom, tipus) {
     window.java.historial_set(nom, tipus);
 }

$(document).ready(function() {
	setTimeout(carrega,100);

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
 	 		password = $("#loginform_pass").val();
 	 		$("#formAccount_newUsername").val(username);
 	 		Materialize.updateTextFields();
 	 		Materialize.toast('Accedint al teu compte...', 2000);
	 		$("#logo_container").fadeOut(1000);
	 		$("#logo_container h3").fadeOut(1000);
	 		$("#logo_container img").fadeOut(1000);
	 		$("#signin").fadeOut(1000);
	 		$('select').material_select();
	 		$("#collapsibleConsulta li").css({ "display": "none" });
	 		getHistorial();
	 		setTimeout(function() { $("#homepage").fadeIn(1000); $("#nomusuariContainer").text(username); }, 1000);
 	 	}
 	 	else Materialize.toast("Login Incorrecte",2000);
	 	
 	 });
 	 $("#guest_entry").on("click", function(e) {
 	 	$("#nomusuariContainer").text("Convidat");
 	 	Materialize.updateTextFields();
 	 	Materialize.toast('Accedint a l`aplicació...', 2000);
 	 	$("#logo_container").fadeOut(1000);
 		$("#logo_container h3").fadeOut(1000);
 		$("#logo_container img").fadeOut(1000);
 		$("#signin").fadeOut(1000);
 		$('select').material_select();
 		$("#configurarCompteBtn").css({"display": "none"});
 		$("#collapsibleConsulta li").css({ "display": "none" });
 		setTimeout(function() { $("#homepage").fadeIn(1000); }, 1000);
 	 });
 	 $("#adminform_submit").on("click", function(e) {
 	 	if ($("#adminform_user").val() == "Administrador" && $("#adminform_pass").val() == "1234") {
 	 		username = $("#adminform_user").val();
 	 		password = $("#adminform_pass").val();
 	 		isAdmin = true;
 	 		$("#formAccount_newUsername").val(username);
 	 		Materialize.updateTextFields();
 	 		Materialize.toast('Accedint al teu compte...', 2000);
	 		$("#logo_container").fadeOut(1000);
	 		$("#logo_container h3").fadeOut(1000);
	 		$("#logo_container img").fadeOut(1000);
	 		$("#signin").fadeOut(1000);
	 		$('select').material_select();
	 		getHistorial();
	 		$("#collapsibleConsulta li").css({ "display": "none" });
	 		setTimeout(function() { 
	 			$("#homepage").fadeIn(1000); 
	 			$("#nomusuariContainer").text(username); 
	 			$("#opcions_admin").css({ "display": "block" });
	 		}, 1000);
 	 	}
 	 	else Materialize.toast("Login Incorrecte",2000);
 	 });
 	 $("#historial_button").on("click", function(e) {
 	 	e.stopPropagation();
 	 	if(username != "") {
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
 	 	} else Materialize.toast("Aquesta acció no està disponible en mode convidat.", 2000);
 	 });
 	 $("html").click(function() {
 	 	if(vHistorial) {
 	 		$("#historial").animate({
 	 			"height": "0px"
 	 		}, 1000, function() { $("#historial").fadeOut(0); });
 	 		vHistorial = false;
 	 	}
 	 });
 	 $("#historial").click(function(e) {
 	 	e.stopPropagation();
 	 });
 	 $("#tancabutton").on("click",function(e) {
 	 	username = "";
 	 	password = "";
 	 	isAdmin = false;
 	 	$("#opcions_admin").css({ "display": "none" });
 	 	$("#configurarCompteBtn").css({"display": "block"});
 	 	$("#homepage").fadeOut(1000);
	 	setTimeout(function() { 
	 		$("#logo_container").fadeIn(1000);
	 		$("#logo_container h3").fadeIn(1000);
	 		$("#logo_container img").fadeIn(1000);
	 		$("#signin").fadeIn(1000); 
	 	}, 1000);
 	 });
 	 $("#username_submit").on("click", function(e) {
 	 	if(window.java.CanviarUsername(username, password, $("#formAccount_newUsername").val())) {
 	 		username = $("#formAccount_newUsername").val();
 	 		$("#modalConfigurarCompte").closeModal();
 	 		$("#nomusuariContainer").text(username);
 	 		Materialize.toast("Nom d'usuari canviat correctament!", 2000);
 	 	} else {
 	 		Materialize.toast("Ja existeix un usuari amb aquest nom. Prova-ho amb un de diferent.", 2000);
 	 	}
 	 });
 	 $("#password_submit").on("click", function(e) {
 	 	if(window.java.CanviarPassword(username, $("#formAccount_newPassword").val(), $("#formAccount_newPassword2").val())) {
 	 		password = $("#formAccount_newPassword2").val();
 	 		$("#modalConfigurarCompte").closeModal();
 	 		Materialize.toast("Contrasenya canviada correctament!", 2000);
 	 	} else {
 	 		Materialize.toast("La contrasenya actual no és correcta. Torna-ho a provar.", 2000);
 	 	}
 	 });

 	 $("#search").bind("enterKey",function(e) {
 	 	consulta();
 	 	getHistorial();
 	 });
 	 $("#search").keyup(function(e) {
 	 	if(e.keyCode == 13) {
 	 		$(this).trigger("enterKey");
 	 	}
 	 });

 	 $('.modal-trigger').leanModal();
 });