<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Front-Office - Accueil</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/frontoffice.css">
</head>
<body>
    <header class="header">
        <div class="logo">MonSite</div>
        <nav class="nav">
            <ul>
                <li><a href="#">Accueil</a></li>
                <li><a href="#">À Propos</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>
    
    <section class="hero">
        <div class="hero-content">
            <h1>Bienvenue sur MonSite</h1>
            <p>Découvrez nos services exceptionnels et laissez-vous inspirer.</p>
            <a href="#" class="btn-primary">En savoir plus</a>
        </div>
    </section>
    
    <section class="features">
        <div class="feature-card">
            <h3>Fiabilité</h3>
            <p>Nous garantissons un service de qualité et sécurisé.</p>
        </div>
        <div class="feature-card">
            <h3>Innovation</h3>
            <p>Des solutions modernes adaptées à vos besoins.</p>
        </div>
        <div class="feature-card">
            <h3>Support</h3>
            <p>Une équipe toujours à votre écoute.</p>
        </div>
    </section>
    
    <footer class="footer">
        <p>&copy; 2025 MonSite. Tous droits réservés.</p>
    </footer>
</body>
</html>
