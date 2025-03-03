<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="entite.Vol, java.util.List"%>
<%
    List<Vol> vols = (List<Vol>) request.getAttribute("vols");
%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/liste_vol.css">
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

