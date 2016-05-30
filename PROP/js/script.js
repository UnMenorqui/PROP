 var vHistorial = false;
 var username = "";
 var password = "";
 var isAdmin = false;
 var actua = false;

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

 function loadHistorialElement(elem) {
 	$("#search").val(elem);
 	$("#Tipus_Node").val("General");
 	consulta();

 }

 function carrega() {
 	if(window.java.CreaGraf()) {
 		if (actua == true) {
 	 		actua = false;
 	 		afterLoading();
 	 	}
 	 	else {
 	 		afterLoading();
 	 	}
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
 	$("#collapsibleConsulta").css({"display": "none"});
 	$("#loadingConsulta").css({ "display": "block" });
 	amagarCollapsible();
 	setTimeout(function() {
 		var perfil = window.java.consulta($("#Tipus_Node").val(),$("#search").val(),parseInt($("#rangeAutors").val()),parseInt($("#rangeTermes").val()),parseInt($("#rangeConferencies").val()),parseInt($("#rangeArticles").val()),(username != ""));	 	$("#collapsibleConsulta").text(perfil);
	 	if (perfil == "-1") {
	 		$("#collapsibleConsulta").css({"display": "none"});
 			$("#loadingConsulta").css({ "display": "none" });
 			Materialize.toast("No s'ha trobat cap node amb aquesta entitat.",2000);
	 	}
	 	else {
	 		perfil = JSON.parse(perfil);
		 	var tipus = $("#Tipus_Node").val();
		 	if (tipus == "General") {
		 		if(window.java.existeixnode($("#search").val(),"Autor")) tipus = "Autor";
		 		else if (window.java.existeixnode($("#search").val(),"Conferencia")) tipus = "Conferencia";
		 		else if (window.java.existeixnode($("#search").val(),"Terme")) tipus = "Terme";
		 		else if (window.java.existeixnode($("#search").val(),"Article")) tipus = "Article";
		 	}
		 
		 	if (perfil != "No s'ha trobat") {
		 		//if(!comprovaHistorial($("#search").val())) 
		 			setConsultaHistorial($("#search").val(),tipus);
		 	} else {
		 		$("#collapsibleConsulta").css({"display": "block"});
	 			$("#loadingConsulta").css({ "display": "none" });
	 			Materialize.toast("No s'ha trobat cap resultat", 2000);
		 	}
		 	if (tipus == "Autor") {
		 		$("#collapsibleConsulta").css({"display": "block"});
	 			$("#loadingConsulta").css({ "display": "none" });
		 		$("#collapsibleArticles").fadeIn(0);
			 	$("#collapsibleConferencies").fadeIn(0);
			 	$("#collapsibleCoautors").fadeIn(0);
			 	$("#collapsibleTermes").fadeIn(0);

			 	$("#collapsibleArticles .collapsible-body ul").html("");
			 	for(article in perfil[0]) {
			 		$("#collapsibleArticles .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[0][article] +"\")'>"+ perfil[0][article] +"</span></li>");
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
			 		$("#collapsibleConferencies .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[1][conf] +"\")'>"+ perfil[1][conf] +"</span></li>");
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
			 		$("#collapsibleCoautors .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[2][coautor] +"\")'>"+ perfil[2][coautor] +"</span></li>");
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
			 		$("#collapsibleTermes .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[3][terme] +"\")'>"+ perfil[3][terme] +"</span></li>");
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
				$("#collapsibleConsulta").css({"display": "block"});
	 			$("#loadingConsulta").css({ "display": "none" });
			 	$("#collapsibleConferencies").fadeIn(0);
			 	$("#collapsibleAutors").fadeIn(0);
			 	$("#collapsibleTermes").fadeIn(0);

			 	$("#collapsibleConferencies .collapsible-body ul").html("");
			 	for(conf in perfil[0]) {
			 		$("#collapsibleConferencies .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[0][conf] +"\")'>"+ perfil[0][conf] +"</span></li>");
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
			 		$("#collapsibleAutors .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[1][autor] +"\")'>"+ perfil[1][autor] +"</span></li>");
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
			 		$("#collapsibleTermes .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[2][terme] +"\")'>"+ perfil[2][terme] +"</span></li>");
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
				$("#collapsibleConsulta").css({"display": "block"});
	 			$("#loadingConsulta").css({ "display": "none" });
				$("#collapsibleArticles").fadeIn(0);
			 	$("#collapsibleAutors").fadeIn(0);
			 	$("#collapsibleTermes").fadeIn(0);

				$("#collapsibleArticles .collapsible-body ul").html("");
			 	for(article in perfil[0]) {
			 		$("#collapsibleArticles .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[0][article] +"\")'>"+ perfil[0][article] +"</span></li>");
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
			 		$("#collapsibleAutors .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[1][autor] +"\")'>"+ perfil[1][autor] +"</span></li>");
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
			 		$("#collapsibleTermes .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[2][terme] +"\")'>"+ perfil[2][terme] +"</span></li>");
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
				$("#collapsibleConsulta").css({"display": "block"});
	 			$("#loadingConsulta").css({ "display": "none" });
				$("#collapsibleArticles").fadeIn(0);
			 	$("#collapsibleConferencies").fadeIn(0);
			 	$("#collapsibleAutors").fadeIn(0);

			 	$("#collapsibleArticles .collapsible-body ul").html("");
			 	for(article in perfil[0]) {
			 		$("#collapsibleArticles .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[0][article] +"\")'>"+ perfil[0][article] +"</span></li>");
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
			 		$("#collapsibleConferencies .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[1][conf] +"\")'>"+ perfil[1][conf] +"</span></li>");
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
			 		$("#collapsibleAutors .collapsible-body ul").append("<li><span style='font-weight: bold' onclick='loadHistorialElement(\""+ perfil[2][autor] +"\")'>"+ perfil[2][autor] +"</span></li>");
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

			getHistorial();
		}
	},250);
 }

 function afegirNode() {
 	if(confirm("Estàs segur que d'afegir el Node?")) {
	 	if (window.java.afegirNode($("#afegirNodeTipus").val(), $("#afegirNodeNom").val())) {
	 		Materialize.toast("Node afegit correctament.",3000);
	 		actua = true;
	 	}
	 	else {
	 		Materialize.toast("Node ja existent.",3000);
	 	}
	 }
 } 

 function eliminarNode() {
 	if(confirm("Estàs segur d'eliminar el Node?")){
	 	if (window.java.eliminarNode($("#eliminarNodeNom").val())) {
	 		Materialize.toast("Node eliminat correctament.",3000);
	 		actua = true;
	 	}
	 	else {
	 		Materialize.toast("Node no existent.",3000);
	 	}
	 }
 }

 function afegirAresta() {
 	if(confirm("Estàs segur que vols afegir l'aresta?")) {
	 	var id = window.java.afegirAresta($("#afegirArestaNom").val(), $("#afegirArestaNom2").val());
	 	if (id == '0') Materialize.toast("Node1 NO existent",3000);
	 	else if (id == '1') Materialize.toast("Node2 NO existent",3000);
		else if (id == '2') Materialize.toast("Aresta ja existent",3000);
		else {
			Materialize.toast("Aresta afegida correctament",3000);
			actua = true;
		}
	}
 }

 function eliminarAresta() {
 	if(confirm("Estàs segur que vols eliminar l'aresta?")) {
	 	var id = window.java.eliminarAresta($("#eliminarArestaNom").val(), $("#eliminarArestaNom2").val());
	 	if (id == '0') Materialize.toast("Node1 NO existent",3000);
		if (id == '1') Materialize.toast("Node2 NO existent",3000);
		if (id == '2') Materialize.toast("Aresta NO existent",3000);
		if (id == '3') {
			Materialize.toast("Aresta eliminada correctament",3000);
			actua = true;
		}
	}
 }

 function eliminarUsuariAdmin() {
 	if(confirm("Estàs segur que vols borrar aquesta usuari de la BD?")){
 		var id = window.java.BorraUsuariAdmin($("#eliminarUsuariNom").val());
 		if (id == 0) Materialize.toast("Usuari no-existent.",2000);
 		else {
 			Materialize.toast("Usuari eliminat correctament.",2000);
 		}
 	}
 }	

 function consultarUsuarisAdmin() {
 	var llista = JSON.parse(window.java.consultausuarisBD());
 	$("#llistaUsuaris ul").html("");
 	llista.forEach(function(elem, i) {
 		$("#llistaUsuaris ul").append("<li>"+ elem +"</li>");
 	});
 }

 function getHistorial() {
     var hist = JSON.parse(window.java.historial_get(username));

     $("#historial .collection").html("");
     hist.forEach(function(elem, i) {
     	$("#historial .collection").append("<li class='collection-item'><span onclick='loadHistorialElement(\"" + elem + "\")'>" + elem + "</span><a href='#!' class='secondary-content' onclick='borrarElementHistorial(" + i + ")'><i class='material-icons'>delete</i></a></li>");
     });
 }

 function borrarElementHistorial(n) {
 	if(confirm("Estàs segur que vols borrar aquesta entrada de l'historial?")) {
     window.java.historial_remove(n, username);
     getHistorial();
 	}
 }

 function setConsultaHistorial(nom, tipus) {
     window.java.historial_set(nom, tipus, username);
 }

 function comprovaHistorial(nom) {
 	var bool = false;
 	$("#historial .collection .collection-item").each(function(elem) {
 		var n = $("span", elem).text();
 		if(n == nom) bool = true;
 	});
 	return bool;
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
 	 	if (window.java.login($("#loginform_user").val(),$("#loginform_pass").val())) {
 	 		username = window.java.consulta_username();
 	 		password = window.java.consulta_password();
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
 	 	Materialize.toast("Accedint a l'aplicació...", 2000);
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
 	 	if ($("#adminform_user").val() == "admin" && $("#adminform_pass").val() == "1234") {
 	 		username = $("#adminform_user").val();
 	 		password = $("#adminform_pass").val();
 	 		isAdmin = true;
 	 		$("#formAccount_newUsername").val(username);
 	 		Materialize.updateTextFields();
 	 		Materialize.toast("Accedint al compte d'Administrador...", 2000);
	 		$("#logo_container").fadeOut(1000);
	 		$("#logo_container h3").fadeOut(1000);
	 		$("#logo_container img").fadeOut(1000);
	 		$("#signin").fadeOut(1000);
	 		$("#configurarCompteBtn").css({"display": "none"});
	 		$('select').material_select();
	 		getHistorial();
	 		amagarCollapsible();
	 		setTimeout(function() { 
	 			$("#homepage").fadeIn(1000); 
	 			$("#nomusuariContainer").text(username); 
	 			$("#opcions_admin").css({ "display": "block" });
	 			$("#admin_graf").css({ "display": "block" });
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
	 	 		}, 250, function() { $("#historial").fadeOut(0); });
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
 	 		}, 250, function() { $("#historial").fadeOut(0); });
 	 		vHistorial = false;
 	 	}
 	 });
 	 $("#historial").click(function(e) {
 	 	e.stopPropagation();
 	 });
 	 $("#tancabutton").on("click",function(e) {
 	 	window.java.logout();
 	 	username = "";
 	 	password = "";
 	 	isAdmin = false;
 	 	if (actua) {
 	 		if(confirm("S'han produït canvis a la BD, vols aplicar-los?")) {
 	 			Materialize.toast("S'està actualitzant la Base de Dades.",2000);
 	 			if (window.java.actualitzar()) {
 	 				Materialize.toast("Base de Dades Actualitzada.",2000);
 	 				setTimeout(function() { Materialize.toast("Creant connexions entre nodes",2000);}, 500);
 	 				setTimeout(function() { location.reload()}, 3000);
 	 			}
 			}
 	 	}
 	 	else {
	 	 	$("#opcions_admin").css({ "display": "none" });
	 	 	$("#admin_graf").css({ "display": "none" });
	 	 	$("#configurarCompteBtn").css({"display": "none"});
	 	 	$("#homepage").fadeOut(1000);
	 	 	$("#logo_container").fadeIn(1000);
	 		$("#logo_container h3").fadeIn(1000);
	 		$("#logo_container img").fadeIn(1000);
	 		$("#signin").fadeIn(1000); 
	 	 }
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

 	 $("#rangeArticles").on("change", function(e){
 	 	$("#rangeArticles_").val($("#rangeArticles").val());
 	 });
 	 $("#rangeArticles_").on("change", function(e){
 	 	if($("#rangeArticles_").val() < 0 || $("#rangeArticles_").val() > 200 || !$.isNumeric($("#rangeConferencies_").val())) {
 	 		$("#rangeArticles_").val($("#rangeArticles").val());
 	 		Materialize.toast("El número introduït és massa gran", 2000);
 	 	} else $("#rangeArticles").val($("#rangeArticles_").val());
 	 });
 	 $("#rangeConferencies").on("change", function(e){
 	 	$("#rangeConferencies_").val($("#rangeConferencies").val());
 	 });
 	 $("#rangeConferencies_").on("change", function(e){
 	 	if($("#rangeConferencies_").val() < 0 || $("#rangeConferencies_").val() > 200 || !$.isNumeric($("#rangeConferencies_").val())) {
 	 		$("#rangeConferencies_").val($("#rangeConferencies").val());
 	 		Materialize.toast("El número introduït és massa gran", 2000);
 	 	} else $("#rangeConferencies").val($("#rangeConferencies_").val());
 	 });
 	 $("#rangeAutors").on("change", function(e){
 	 	$("#rangeAutors_").val($("#rangeAutors").val());
 	 });
 	 $("#rangeAutors_").on("change", function(e){
 	 	if($("#rangeAutors_").val() < 0 || $("#rangeAutors_").val() > 200 || !$.isNumeric($("#rangeConferencies_").val())) {
 	 		$("#rangeAutors_").val($("#rangeAutors").val());
 	 		Materialize.toast("El número introduït és massa gran", 2000);
 	 	} else $("#rangeAutors").val($("#rangeAutors_").val());
 	 });
 	 $("#rangeTermes").on("change", function(e){
 	 	$("#rangeTermes_").val($("#rangeTermes").val());
 	 });
 	 $("#rangeTermes_").on("change", function(e){
 	 	if($("#rangeTermes_").val() < 0 || $("#rangeTermes_").val() > 200 || !$.isNumeric($("#rangeConferencies_").val())) {
 	 		$("#rangeTermes_").val($("#rangeTermes").val());
 	 		Materialize.toast("El número introduït és massa gran", 2000);
 	 	} else $("#rangeTermes").val($("#rangeTermes_").val());
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