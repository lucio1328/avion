<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page import="entite.Vol"%>
<%
    Vol vol = (Vol) request.getAttribute("vol");
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Configurer le Vol</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/configuration.css">
</head>
<body>
<div class="config-container">
    <h2>Configurer le Vol <%= vol != null ? vol.getId() : "Inconnu" %></h2>

    <% if (vol == null) { %>
        <p style="color: red;">Aucun vol sélectionné.</p>
    <% }
    else { %>
        <form action="insert_config" method="post">
            <input type="hidden" name="idVol" value="<%= vol.getId() %>">

            <label for="heureReservation">Temps limite de réservation (heures avant départ) :</label>
            <input type="text" id="heureReservation" name="heureReservationAvantVol" class="input-field"
                   value="<%= (vol.getHeureReservationAvantVol() != null) ? vol.getHeureReservationAvantVol() : "" %>" required>

            <label for="heureAnnulation">Temps limite d’annulation (heures avant départ) :</label>
            <input type="text" id="heureAnnulation" name="heureAnnulatioReservationAvantVol" class="input-field"
                   value="<%= (vol.getHeureAnnulatioReservationAvantVol() != null) ? vol.getHeureAnnulatioReservationAvantVol() : "" %>" required>

            <div class="form-actions">
                <a href="liste_vol" class="btn-config-secondary btn-left">⬅ Retour</a>
                <button type="submit" class="btn-config-primary btn-right">Enregistrer</button>
            </div>
        </form>
    <% } %>
</div>
</body>
</html>
