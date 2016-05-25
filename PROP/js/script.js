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

 function amagarCollapsible() {
 	$("#collapsibleArticles").fadeOut(0).removeClass("active");
 	$("#collapsibleArticles .collapsible-header").removeClass("active");
 	$("#collapsibleArticles .collapsible-body").css({ "display": "none" });
 	$("#collapsibleConferencies").fadeOut(0).removeClass("active");
 	$("#collapsibleConferencies .collapsible-header").removeClass("active");
 	$("#collapsibleConferencies .collapsible-body").css({ "display": "none" });
 	$("#collapsibleAutors").fadeOut(0).removeClass("active");
 	$("#collapsibleAutors .collapsible-header").removeClass("active");
 	$("#collapsibleAutors .collapsible-body").css({ "display": "none" });
 	$("#collapsibleCoautors").fadeOut(0).removeClass("active");
 	$("#collapsibleCoautors .collapsible-header").removeClass("active");
 	$("#collapsibleCoautors .collapsible-body").css({ "display": "none" });
 	$("#collapsibleTermes").fadeOut(0).removeClass("active");
 	$("#collapsibleTermes .collapsible-header").removeClass("active");
 	$("#collapsibleTermes .collapsible-body").css({ "display": "none" });
 }

 function consulta() {
 	amagarCollapsible();
	    var perfil = JSON.parse(window.java.consulta($("#Tipus_Node").val(),$("#search").val(),parseInt($("#rangeAutors").val()),parseInt($("#rangeTermes").val()),parseInt($("#rangeConferencies").val()),parseInt($("#rangeArticles").val()),(username != "")));
	 	var tipus = $("#Tipus_Node").val();
	 	if (tipus == "General") {
	 		if(window.java.existeixnode($("#search").val(),"Autor")) tipus = "Autor";
	 		else if (window.java.existeixnode($("#search").val(),"Conferencia")) tipus = "Conferencia";
	 		else if (window.java.existeixnode($("#search").val(),"Terme")) tipus = "Terme";
	 		else if (window.java.existeixnode($("#search").val(),"Article")) tipus = "Article";
	 	}
	 
	 	if (perfil != "No s'ha trobat") {
	 		setConsultaHistorial($("#search").val(),tipus);
	 	}
	 	if (tipus == "Autor") {
	 		$("#collapsibleArticles").fadeIn(0);
		 	$("#collapsibleConferencies").fadeIn(0);
		 	$("#collapsibleCoautors").fadeIn(0);
		 	$("#collapsibleTermes").fadeIn(0);

		 	$("#collapsibleArticles .collapsible-body ul").html("");
		 	for(article in perfil[0]) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>"+ perfil[0][article] +"</li>");
		 	}
		 	if (perfil[0].length == 0) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>"+ "No existeixen Articles per aquest autor." +"</li>");
		 	}

		 	else { 
		 		if (parseInt($("#rangeArticles").val()) > perfil[0].length) {
		 			$("#collapsibleArticles .collapsible-body ul").append("<li>"+ "No existeixen suficients Articles per la quantitat demanada." +"</li>");
		 		}
		 	}


		 	$("#collapsibleConferencies .collapsible-body ul").html("");
		 	for(conf in perfil[1]) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>"+ perfil[1][conf] +"</li>");
		 	}

		 	if (perfil[1].length == 0) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>"+ "No existeixen Conferències per aquest autor." +"</li>");
		 	}
		 	else {
		 		if (parseInt($("#rangeConferencies").val()) > perfil[1].length) {
		 			$("#collapsibleConferencies .collapsible-body ul").append("<li>"+ "No existeixen suficientes Conferències per aquest autor." +"</li>");
		 		}
		 	}


		 	$("#collapsibleCoautors .collapsible-body ul").html("");
		 	for(coautor in perfil[2]) {
		 		$("#collapsibleCoautors .collapsible-body ul").append("<li>"+ perfil[2][coautor] +"</li>");
		 	}

		 	if (perfil[2].length == 0) {
		 		$("#collapsibleCoautors .collapsible-body ul").append("<li>" + "No existeixen Co-Autors per aquest autor." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeAutors").val()) > perfil[2].length) {
		 			$("#collapsibleCoautors .collapsible-body ul").append("<li>"+ "No existeixen suficients Articles per la quantitat demanada." +"</li>");
		 		}
		 	}

		 	$("#collapsibleTermes .collapsible-body ul").html("");
		 	for(terme in perfil[3]) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>"+ perfil[3][terme] +"</li>");
		 	}

		 	if (perfil[3].length == 0) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen Termes per aquest autor." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeTermes").val()) > perfil[3].length) {
		 			$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen suficients Termes per aquest autor." + "</li>");
		 		}
		 	}
		}

		if (tipus == "Article") {
		 	$("#collapsibleConferencies").fadeIn(0);
		 	$("#collapsibleAutors").fadeIn(0);
		 	$("#collapsibleTermes").fadeIn(0);


		 	$("#collapsibleConferencies .collapsible-body ul").html("");
		 	for(conf in perfil[0]) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>"+ perfil[0][conf] +"</li>");
		 	}

		 	if (perfil[0].length == 0) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>" + "No existeixen Conferencies per aquest Article." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeConferencies").val()) > perfil[0].length) {
		 			$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen suficientes Conferencies per aquest Article." + "</li>");
		 		}
		 	}


		 	$("#collapsibleAutors .collapsible-body ul").html("");
		 	for(autor in perfil[1]) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>"+ perfil[1][autor] +"</li>");
		 	}

		 	if (perfil[1].length == 0) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>" + "No existeixen Autors per aquest Article." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeAutors").val()) > perfil[1].length) {
		 			$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen suficientes Autors per aquest Article." + "</li>");
		 		}
		 	}


		 	$("#collapsibleTermes .collapsible-body ul").html("");
		 	for(terme in perfil[2]) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>"+ perfil[2][terme] +"</li>");
		 	}

		 	if (perfil[2].length == 0) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen Termes per aquest Article." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeTermes").val()) > perfil[2].length) {
		 			$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen suficientes Conferencies per aquest Article." + "</li>");
		 		}
		 	}

		}

		if (tipus == "Conferencia") {
			$("#collapsibleArticles").fadeIn(0);
		 	$("#collapsibleAutors").fadeIn(0);
		 	$("#collapsibleTermes").fadeIn(0);

			$("#collapsibleArticles .collapsible-body ul").html("");
		 	for(article in perfil[0]) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>"+ perfil[0][article] +"</li>");
		 	}

		 	if (perfil[0].length == 0) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>" + "No existeixen Articles per aquesta Conferencia." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeArticles").val()) > perfil[0].length) {
		 			$("#collapsibleArticles .collapsible-body ul").append("<li>" + "No existeixen suficients Articles per aquesta Conferencia." + "</li>");
		 		}
		 	}


		 	$("#collapsibleAutors .collapsible-body ul").html("");
		 	for(autor in perfil[1]) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>"+ perfil[1][autor] +"</li>");
		 	}

		 	if (perfil[1].length == 0) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>" + "No existeixen Autors per aquesta Conferencia." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeAutors").val())> perfil[1].length) {
		 			$("#collapsibleAutors .collapsible-body ul").append("<li>" + "No existeixen suficients Autors per aquesta Conferencia." + "</li>");
		 		}
		 	}


		 	$("#collapsibleTermes .collapsible-body ul").html("");
		 	for(terme in perfil[2]) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>"+ perfil[2][terme] +"</li>");
		 	}

		 	if (perfil[2].length == 0) {
		 		$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen Termes per aquesta Conferencia." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeTermes").val()) > perfil[2].length) {
		 			$("#collapsibleTermes .collapsible-body ul").append("<li>" + "No existeixen suficients Termes per aquesta Conferencia." + "</li>");
		 		}
		 	}

		}

		if (tipus == "Terme") {
			$("#collapsibleArticles").fadeIn(0);
		 	$("#collapsibleConferencies").fadeIn(0);
		 	$("#collapsibleAutors").fadeIn(0);

		 	$("#collapsibleArticles .collapsible-body ul").html("");
		 	for(article in perfil[0]) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>"+ perfil[0][article] +"</li>");
		 	}

		 	if (perfil[0].length == 0) {
		 		$("#collapsibleArticles .collapsible-body ul").append("<li>" + "No existeixen Articles per aquest Terme." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeArticles").val()) > perfil[0].length) {
		 			$("#collapsibleArticles .collapsible-body ul").append("<li>" + "No existeixen suficients Articles per aquest Terme." + "</li>");
		 		}
		 	}


		 	$("#collapsibleConferencies .collapsible-body ul").html("");
		 	for(conf in perfil[1]) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>"+ perfil[1][conf] +"</li>");
		 	}

		 	if (perfil[1].length == 0) {
		 		$("#collapsibleConferencies .collapsible-body ul").append("<li>" + "No existeixen Conferencies per aquest Terme." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeConferencies").val()) > perfil[1].length) {
		 			$("#collapsibleConferencies .collapsible-body ul").append("<li>" + "No existeixen suficientes Conferencies per aquest Terme." + "</li>");
		 		}
		 	}


		 	$("#collapsibleAutors .collapsible-body ul").html("");
		 	for(autor in perfil[2]) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>"+ perfil[2][autor] +"</li>");
		 	}

		 	if (perfil[2].length == 0) {
		 		$("#collapsibleAutors .collapsible-body ul").append("<li>" + "No existeixen Autors per aquest Terme." + "</li>");
		 	}

		 	else {
		 		if (parseInt($("#rangeAutors").val()) > perfil[2].length) {
		 			$("#collapsibleAutors .collapsible-body ul").append("<li>" + "No existeixen suficients Autors per aquest Terme." + "</li>");
		 		}
		 	}
		}
 }

 function getHistorial() {
     var hist = JSON.parse(window.java.historial_get());

     $("#historial .collection").html("");
     hist.forEach(function(elem, i) {
     	$("#historial .collection").append("<li class='collection-item'><span>" + elem + "</span><a href='#!' class='secondary-content' onclick='borrarElementHistorial(" + i + ")'><i class='material-icons'>delete</i></a></li>");
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

    $('.collapsible').collapsible({
    	accordion : false
    });

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
	 		amagarCollapsible();
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
 		amagarCollapsible();
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
	 		amagarCollapsible();
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
 	 $("#historial .collection-item").on("click", function(e) { Materialize.toast("adf",2000);
 	 	e.preventDefault();
 	 	var entitat = $("span", this).text();
 	 	$("#search").val(entitat);
 	 	$("#Tipus_Node").val("General")
 	 	consulta();
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