<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="entite.PromotionVol, entite.TypeSiege, java.util.List, java.util.Map" %>
<%
    Map<Integer, PromotionVol> promotions = (Map<Integer, PromotionVol>) request.getAttribute("promotions");
    List<TypeSiege> typeSieges = (List<TypeSiege>) request.getAttribute("typeSieges");
    Integer idVol = (Integer) request.getAttribute("idVol");

    String message = (String) request.getAttribute("message");
    String error = (String) request.getAttribute("error");
%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/promotion.css">

<div class="content-wrapper">
    <div class="page-header">
        <h2 class="welcome-title">Gestion des promotions</h2>
        <a href="liste_vol" class="btn-back">⬅ Retour aux vols</a>
    </div>

    <div class="table-container">
        <h3>Promotions Vol</h3>
        <% if (message != null) { %>
            <div class="alert success">
                <%= message %>
            </div>
        <% } %>

        <% if (error != null) { %>
            <div class="alert error">
                <%= error %>
            </div>
        <% } %>
        <form action="insert_promotion" method="POST">
        <input type="hidden" name="idVol" value="<%= idVol %>">

        <label for="datePromotion">Date de la promotion :</label>
        <input type="date" id="datePromotion" name="datePromotion" class="input-field">

        <table class="data-table">
            <thead>
                <tr>
                    <th>Type de siège</th>
                    <th>Nombre de places</th>
                    <th>Réduction (%)</th>
                </tr>
            </thead>
            <tbody>
                <%
                if (typeSieges != null && !typeSieges.isEmpty()) {
                    for (TypeSiege typeSiege : typeSieges) {
                        PromotionVol promo = promotions.get(typeSiege.getId());
                %>
                    <tr>
                        <td>
                            <%= typeSiege.getLibelle() %>
                            <input type="hidden" name="promotionVols[<%= typeSiege.getId() %>].typeSiege.id" value="<%= typeSiege.getId() %>">
                        </td>
                        <td>
                            <input type="number" name="promotionVols[<%= typeSiege.getId() %>].nombrePlace"
                                value="<%= (promo != null) ? promo.getNombrePlace() : 1 %>" min="1">
                        </td>
                        <td>
                            <input type="number" name="promotionVols[<%= typeSiege.getId() %>].pourcentage"
                                value="<%= (promo != null) ? promo.getPourcentage() : 0 %>" step="0.01" min="0" max="100">
                        </td>
                    </tr>
                <% 
                    }
                } else { 
                %>
                    <tr>
                        <td colspan="3">Aucun type de siège trouvé.</td>
                    </tr>
                <% 
                }
                %>
            </tbody>
        </table>
        <button type="submit" class="btn-save">💾 Enregistrer les modifications</button>
    </form>
    </div>
</div>
