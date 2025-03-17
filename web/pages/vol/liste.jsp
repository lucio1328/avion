<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="entite.Vol, java.util.List"%>
<%
    List<Vol> vols = (List<Vol>) request.getAttribute("vols");
%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/liste_vol.css">
<div>
    <form action="search_vols" method="get">
        <label for="avion">Avion :</label>
        <select name="avion" id="avion">
            <option value="">--Sélectionner un avion--</option>
            <% 
                List<Avion> avions = (List<Avion>) request.getAttribute("avions");
                for (Avion avion : avions) {
            %>
                <option value="<%= avion.getId() %>"><%= avion.getModele().getLibelle() %></option>
            <% } %>
        </select>
        <br>

        <label for="date_depart_start">Date de départ (Début) :</label>
        <input type="date" name="date_depart_start" id="date_depart_start">
        <br>

        <label for="date_depart_end">Date de départ (Fin) :</label>
        <input type="date" name="date_depart_end" id="date_depart_end">
        <br>

        <label for="duree_min">Durée minimale (h) :</label>
        <input type="number" name="duree_min" id="duree_min" step="0.1">
        <br>

        <label for="duree_max">Durée maximale (h) :</label>
        <input type="number" name="duree_max" id="duree_max" step="0.1">
        <br>

        <label for="ville">Ville desservie :</label>
        <select name="ville" id="ville">
            <option value="">--Sélectionner une ville--</option>
            <%
                // Récupérer la liste des villes depuis la base de données pour l'affichage dans le select
                List<VilleDesservie> villes = (List<VilleDesservie>) request.getAttribute("villes");
                for (VilleDesservie ville : villes) {
            %>
                <option value="<%= ville.getId() %>"><%= ville.getNom() %></option>
            <% } %>
        </select>
        <br>

        <button type="submit">Rechercher</button>
    </form>
</div>
<div class="content-wrapper">
    <div class="page-header">
        <h2 class="welcome-title">Liste des vols</h2>
        <a href="insert_vol" class="btn-add">
            + Ajouter vol
        </a>
    </div>

    <div class="table-container">
        <% if(vols.isEmpty()) { %>
            <div class="empty-state">
                <h3>Aucun vol</h3>
                <p>Commencez par ajouter un nouveau vol</p>
            </div>
        <% } else { %>
            <div class="table-wrapper">
                <table class="data-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Avion</th>
                            <th>Date de départ</th>
                            <th>Durée (h)</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Vol vol : vols) { %>
                            <tr>
                                <td><%= vol.getId() %></td>
                                <td><%= vol.getAvion().getModele().getLibelle() %></td>
                                <td><%= vol.getDateDepart() %></td>
                                <td><%= vol.getDuree() %></td>
                                <td class="actions">
                                    <div class="dropdown">
                                        <button class="dropbtn">⚙️ Options</button>
                                        <div class="dropdown-content">
                                            <a href="configuration?idVol=<%= vol.getId() %>">🛠 Configurer</a>
                                            <a href="#">👁 Voir détails</a>
                                            <a href="#">✏ Modifier</a>
                                            <a href="ajouter_promotion?idVol=<%= vol.getId() %>">🎟 Ajouter promotion</a>
                                            <a href="#" onclick="confirmDelete(<%= vol.getId() %>)" class="delete-btn">❌ Supprimer</a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } %>
    </div>
</div>
<script>
    function confirmDelete(volId) {
        if (confirm("Voulez-vous vraiment supprimer ce vol ?")) {
            window.location.href = "delete_vol?idVol=" + volId;
        }
    }
</script>

