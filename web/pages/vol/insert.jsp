<%@page import="java.util.List, entite.Avion"%>
<%
    List<Avion> avions = (List<Avion>) request.getAttribute("avions");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Vol</title>
    <link rel="stylesheet" href="assets/css/insert_vol.css">
</head>
<body class="p-6 bg-gray-100">
    <div class="max-w-2xl mx-auto bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-xl font-bold mb-4">Ajouter un Vol</h2>
        <form action="insert_vol" method="post" id="flightForm">
            
            <label class="block mb-2">Avion:</label>
            <select name="idAvion" class="w-full p-2 border rounded mb-4">
                <% for(Avion avion : avions) { %>
                    <option value="<%= avion.getId() %>"><%= avion.getModele().getLibelle() %></option>
                <% } %>
            </select>
            
            <label class="block mb-2">Date de départ:</label>
            <input type="datetime-local" name="dateDepart" class="w-full p-2 border rounded mb-4" required>
            
            <label class="block mb-2">Durée (en heures):</label>
            <input type="number" name="duree" step="0.01" class="w-full p-2 border rounded mb-4" required>
            
            <label class="block mb-2">Villes traversées:</label>
            <div id="villesContainer" class="space-y-2">
                <div class="flex items-center space-x-2">
                    <input type="text" name="villes[]" class="w-full p-2 border rounded" placeholder="Ville de départ" required>
                </div>
                <div class="flex items-center space-x-2">
                    <input type="text" name="villes[]" class="w-full p-2 border rounded" placeholder="Ville d'arrivée" required>
                </div>
            </div>
            <button type="button" onclick="addVille()" class="mt-2 bg-green-500 text-white p-2 rounded">Ajouter une ville</button>
            
            <button type="submit" class="w-full mt-4 bg-blue-600 text-white p-2 rounded">Ajouter Vol</button>
        </form>
    </div>

    <script>
        function addVille() {
            const container = document.getElementById("villesContainer");
            const div = document.createElement("div");
            div.classList.add("flex", "items-center", "space-x-2");
            div.innerHTML = `
                <input type="text" name="villes[]" class="w-full p-2 border rounded" placeholder="Ville intermédiaire" required>
                <button type="button" onclick="removeVille(this)" class="bg-red-500 text-white p-2 rounded">-</button>
            `;
            container.appendChild(div);
        }

        function removeVille(button) {
            button.parentElement.remove();
        }
    </script>
</body>
</html>
