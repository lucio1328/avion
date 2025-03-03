-- Création de la base de données
CREATE DATABASE avion;
\c avion;

-- Table rôle
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50)
);

-- Table utilisateur
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255),
    date_naissance DATE,
    login VARCHAR(255),
    mdp VARCHAR(255),
    id_role INT REFERENCES role(id) ON DELETE CASCADE
);

-- Table modèle d'avion
CREATE TABLE modele (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(255)
);

-- Table type de siège
CREATE TABLE type_siege (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(255)
);

-- Table avion
CREATE TABLE avion (
    id SERIAL PRIMARY KEY,
    id_modele INT REFERENCES modele(id) ON DELETE CASCADE,
    date_fabrication DATE
);

-- Table qui lie avion et type de siège
CREATE TABLE avion_siege (
    id_avion INT REFERENCES avion(id) ON DELETE CASCADE,
    id_type_siege INT REFERENCES type_siege(id) ON DELETE CASCADE,
    nombre_place INT NOT NULL,
    prix DECIMAL(10, 4),
    date_modification DATE
);

-- Table ville desservie
CREATE TABLE ville_desservie (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    pays VARCHAR(255)
);

-- Table vol
CREATE TABLE vol (
    id SERIAL PRIMARY KEY,
    id_avion INT REFERENCES avion(id) ON DELETE CASCADE,
    date_depart TIMESTAMP NOT NULL,
    duree DECIMAL(10, 2),
    heure_reservation_avant_vol INT,
    heure_annulation_reservation_avant_vol INT
);

-- Table qui relie vol et ville desservie
CREATE TABLE vol_ville (
    id_vol INT REFERENCES vol(id) ON DELETE CASCADE,
    id_ville INT REFERENCES ville_desservie(id) ON DELETE CASCADE
);

-- Table promotion sur les vols
CREATE TABLE promotion_vol (
    id_vol INT REFERENCES vol(id) ON DELETE CASCADE,
    id_type_siege INT REFERENCES type_siege(id) ON DELETE CASCADE,
    nombre_place INT NOT NULL,
    pourcentage DECIMAL(10, 2),
    date_promotion TIMESTAMP NOT NULL
);

-- Table statut de la réservation
CREATE TABLE statut (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(255)
);

-- Table réservation
CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    id_user INT REFERENCES users(id) ON DELETE CASCADE,
    id_vol INT REFERENCES vol(id) ON DELETE CASCADE,
    date_reservation TIMESTAMP
);

-- Table état de la réservation
CREATE TABLE reservation_etat (
    id_reservation INT REFERENCES reservation(id) ON DELETE CASCADE,
    id_statut INT REFERENCES statut(id) ON DELETE CASCADE,
    id_type_siege INT REFERENCES type_siege(id) ON DELETE CASCADE,
    nombre_place INT NOT NULL,
    daty TIMESTAMP
);
