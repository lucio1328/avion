<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un utilisateur</title>
    <link href="<%= request.getContextPath() %>/assets/css/form.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="content-wrapper">
            <h2 class="welcome-title">Créer un utilisateur</h2>

            <% if (error != null) { %>
                <span style="color : red"><%= error %></span>
            <% } %>

            <% if (success != null) { %>
                <span style="color : green"><%= success %></span>
            <% } %>

            <form action="creer_utilisateur" method="post">
                <div class="form-group">
                    <label class="form-label" for="nom">Nom :</label>
                    <div class="input-group">
                        <input class="form-input" type="text" name="user.nom" id="nom" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="form-label" for="prenom">Prenom :</label>
                    <div class="input-group">
                        <input class="form-input" type="text" name="user.prenom" id="prenom">
                    </div>
                </div>

                <div class="form-group">
                    <label class="form-label" for="dateNaissance">Date de naissance :</label>
                    <div class="input-group">
                        <input class="form-input" type="date" name="user.dateNaissance" id="dateNaissance">
                    </div>
                </div>

                <div class="form-group">
                    <label class="form-label" for="login">Login :</label>
                    <div class="input-group">
                        <input class="form-input" type="text" name="user.login" id="login" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="form-label" for="mdp">Mot de passe :</label>
                    <div class="input-group">
                        <input class="form-input" type="password" name="user.mdp" id="mdp" required>
                    </div>
                </div>

                <div class="form-actions">
                    <button class="btn-submit" type="submit">Ajouter</button>
                    <button class="btn-reset" type="reset">Réinitialiser</button>
                </div>
            </form>
            <div class="link-container">
                <a href="<%= request.getContextPath() %>/index.jsp" class="link-create">Retour</a>
            </div>
        </div>
    </div>

</body>
</html>
