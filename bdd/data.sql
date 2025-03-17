INSERT INTO role (type) values ('admin'),
    ('user');

INSERT INTO users (nom, prenom, date_naissance, login, mdp, id_role) values
    ('client1', 'client1', '2002-01-12', 'client1', 'client1', 2),
    ('client2', 'client2', '2000-11-04', 'client2', 'client2', 2),
    ('admin1', 'admin1', '1995-05-23', 'admin1', 'admin1', 1);

INSERT INTO modele (libelle) VALUES
    ('Boeing 737'),
    ('Airbus A320'),
    ('Embraer E190'),
    ('Bombardier CRJ900'),
    ('Cessna 172');

INSERT INTO type_siege (libelle) VALUES ('business'),
    ('economique');

INSERT INTO avion (id_modele, date_fabrication) VALUES
    (1, '2018-05-20'),
    (2, '2020-07-15'),
    (3, '2019-03-10'),
    (4, '2021-11-25'),
    (5, '2015-09-05');

INSERT INTO avion_siege (id_avion, id_type_siege, nombre_place, prix, date_modification) VALUES
    (1, 1, 20, 1200.50, '2024-01-10'),
    (1, 2, 150, 300.75, '2024-01-10'),
    (2, 1, 25, 1400.00, '2023-12-05'),
    (2, 2, 160, 350.25, '2023-12-05'),
    (3, 1, 15, 1100.00, '2023-11-20'),
    (3, 2, 90, 280.60, '2023-11-20'),
    (4, 1, 18, 1150.75, '2024-02-01'),
    (4, 2, 95, 295.00, '2024-02-01'),
    (5, 1, 5, 800.00, '2022-10-15'),
    (5, 2, 10, 200.00, '2022-10-15');

INSERT INTO ville_desservie (nom, pays) VALUES
    ('Paris', 'France'),
    ('New York', 'Etats-Unis'),
    ('Tokyo', 'Japon'),
    ('Dubai', 'Emirats arabes unis'),
    ('Londres', 'Royaume-Uni');

INSERT INTO vol (id_avion, date_depart, duree) VALUES
    (1, '2025-03-10 08:00:00', 14.5),
    (2, '2025-04-15 12:30:00', 8.0),
    (3, '2025-05-20 22:00:00', 16.2);

-- Vol 1 : Paris -> Dubaï -> Tokyo
INSERT INTO vol_ville (id_vol, id_ville) VALUES
    (1, 1),
    (1, 4),
    (1, 3);
-- Vol 2 : New York -> Londres
INSERT INTO vol_ville (id_vol, id_ville) VALUES
    (2, 2),
    (2, 5);
-- Vol 3 : Londres -> Dubaï -> Tokyo
INSERT INTO vol_ville (id_vol, id_ville) VALUES
    (3, 5),
    (3, 4),
    (3, 3);

INSERT INTO promotion_vol (id_vol, id_type_siege, nombre_place, pourcentage, date_promotion) VALUES
    (1, 1, 5, 20.00, '2025-03-01 10:00:00');

INSERT INTO statut (libelle) VALUES ('OK'),
    ('Annuler');

INSERT INTO reservation (id_user, id_vol, date_reservation) VALUES
    (4, 1, '2025-02-28 14:00:00'),
    (5, 2, '2025-03-10 09:30:00'),
    (4, 3, '2025-04-01 18:45:00');

INSERT INTO reservation_etat (id_reservation, id_statut, id_type_siege, nombre_place, daty) VALUES
    (4, 1, 2, 2, '2025-02-28 15:00:00'),
    (5, 1, 1, 1, '2025-03-10 10:00:00'),
    (6, 1, 2, 3, '2025-04-01 19:00:00');

INSERT INTO config_enfant (age_enfant, reduction) VALUES (12, 0.3);







