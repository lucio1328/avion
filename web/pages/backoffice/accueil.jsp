<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String view = (String) request.getAttribute("view");
    if(view == null) {
        view = "./home.jsp";
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Backoffice</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/backoffice.css">
</head>
<body>
    <div class="sidebar">
        <h2>Backoffice</h2>
        <a href="logout"><button class="btn btn-primary logout">Déconnexion</button><a>
        <ul>
            <li class="has-submenu">
                <a href="#">Vols <span class="submenu-icon"></span></a>
                <ul>
                    <li><a href="insert_vol">Ajouter un Vol</a></li>
                    <li><a href="liste_vol">Liste des Vols</a></li>
                </ul>
            </li>
            <li class="has-submenu">
                <a href="#">Configuration <span class="submenu-icon"></span></a>
                <ul>
                    <li><a href="configuration.jsp">Reservation</a></li>
                    <li><a href="utilisateurs.jsp">Annulation reservation</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="content">
        <jsp:include page="<%=view%>"/>
    </div>
</body>
</html>
<script src="<%= request.getContextPath() %>/assets/js/backoffice.js"></script>