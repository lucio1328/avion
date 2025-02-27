<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String loginError = (String) request.getAttribute("error_user.login");
    String loginValue = (String) request.getAttribute("value_login");

    String mdpError = (String) request.getAttribute("error_user.mdp");
    String mdpValue = (String) request.getAttribute("value_mdp");
    String error = (String) request.getAttribute("error");

    boolean hasError = error != null || loginError != null || mdpError != null;
    boolean loginSuccess = request.getAttribute("login_success") != null;
%>
<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Ticketing Aérien - Connexion</title>
  <link href="<%= request.getContextPath() %>/assets/css/form.css" rel="stylesheet">
</head>

<body>
  <!-- Animated Airplane -->
  <div id="airplane" class="airplane"></div>

  <main class="container">
    <section class="content-wrapper">
      <h2 class="welcome-title">Se connecter</h2>
      <form action="connection" method="post" class="form-container" id="loginForm">
        <% if (error != null) { %>
            <div class="error-container">
                <%= error %>
            </div>
        <% } %>

        <div class="form-group">
          <label for="login" class="form-label">Login</label>
            <% if (loginError != null) { %>
                <div class="error-message">
                    <%= loginError %>
                </div>
            <% } %>
          <div class="input-group">
            <input type="text" name="user.login" class="form-input" id="login" value="<%= (loginValue != null) ? loginValue : "" %>">
          </div>
        </div>

        <div class="form-group">
            <label for="mdp" class="form-label">Mot de passe</label>
            <% if (mdpError != null) { %>
                <div class="error-message">
                    <%= mdpError %>
                </div>
            <% } %>
            <div class="input-group">
                <input type="password" name="user.mdp" class="form-input password-input" id="mdp" value="<%= (mdpValue != null) ? mdpValue : "" %>">
                <span class="input-group-text toggle-password" onclick="togglePassword()">
                Voir
                </span>
            </div>
        </div>

        <div class="form-actions">
          <button type="submit" class="btn-submit">Se connecter</button>
          <button type="reset" class="btn-reset">Réinitialiser</button>
        </div>
      </form>

      <div class="link-container">
          <a href="creer_admin" class="link-create">Créer un compte admin</a>
          <a href="creer_utilisateur" class="link-create">Créer un compte utilisateur</a>
      </div>

    </section>
  </main>
  
  <script>
    function togglePassword() {
        let passwordField = document.getElementById("mdp");
        if (passwordField.type === "password") {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    }
    
    document.addEventListener("DOMContentLoaded", function() {
        const airplane = document.getElementById("airplane");
        const loginForm = document.getElementById("loginForm");
        
        <% if (hasError) { %>
            airplane.classList.add("crash");
        <% }
        else if (loginSuccess) { %>
            airplane.classList.add("fly-away");

            setTimeout(function() {
                window.location.href = "dashboard";
            }, 3000);
        <% } %>
        loginForm.addEventListener("submit", function(e) {
            const login = document.getElementById("login").value;
            const password = document.getElementById("mdp").value;
            
            if (!login || !password) {
                airplane.classList.add("crash");
            }
            else {

            }
        });
    });
  </script>
</body>

</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String loginError = (String) request.getAttribute("error_user.login");
    String loginValue = (String) request.getAttribute("value_login");

    String mdpError = (String) request.getAttribute("error_user.mdp");
    String mdpValue = (String) request.getAttribute("value_mdp");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Page de connection</title>

  <link href="<%= request.getContextPath() %>/assets/css/connection.css" rel="stylesheet">
</head>

<body>

  <main class="container">
    <section class="content-wrapper">
      <h2 class="welcome-title text-center">Se connecter</h2>
      <form action="connection" method="post" class="form-container">
        <% if (error != null) { %>
            <span style="color : red">
                <%= error %>
            </span>
        <% } %>

        <div class="form-group">
          <label for="login" class="form-label">Login</label>
            <% if (loginError != null) { %>
                <div class="error-message">
                    <%= loginError %>
                </div>
            <% } %>
          <div class="input-group">
            <input type="text" name="user.login" class="form-input" id="login" value="<%= (loginValue != null) ? loginValue : "" %>">
          </div>
        </div>

        <div class="form-group">
            <label for="mdp" class="form-label">Mot de passe</label>
            <% if (mdpError != null) { %>
                <div class="error-message">
                    <%= mdpError %>
                </div>
            <% } %>
            <div class="input-group">
                <input type="password" name="user.mdp" class="form-input password-input" id="mdp" value="<%= (mdpValue != null) ? mdpValue : "" %>">
                <span class="input-group-text toggle-password" onclick="togglePassword()">
                Voir
                </span>
            </div>
        </div>

        <div class="form-actions">
          <button type="submit" class="btn-submit">Se connecter</button>
          <button type="reset" class="btn-reset">Reinitialiser</button>
        </div>
      </form>

    <br/>
    <br/>
    <div class="link-container">
        <a href="creer_admin" class="link-create">Creer un compte admin</a><br/><br/>
        <a href="creer_utilisateur" class="link-create">Creer un compte utilisateur</a>
    </div>

    </section>
  </main>
<script>
    function togglePassword() {
        let passwordField = document.getElementById("mdp");
        if (passwordField.type === "password") {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    }
</script>
</body>

</html> --%>
