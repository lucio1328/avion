create database avion;
\c avion;

create table role (
    id serial primary key,
    type varchar(50)
);

create table users (
    id serial primary key,
    nom varchar(255) not null,
    prenom varchar(255),
    date_naissance date,
    login varchar(255),
    mdp varchar(255),
    id_role int references role(id)
);

create table modele (
    id serial primary key,
    libelle varchar(255)
);

create table type_siege (
    id serial primary key,
    libelle varchar(255)
);

create table avion (
    id serial primary key,
    id_modele int references modele(id),
    date_fabrication date
);

create table avion_siege (
    id_avion int references avion(id),
    id_type_siege int references type_siege(id),
    nombre_place int not null,
    prix decimal(10, 4),
    date_modification date
);

create table ville_desservie (
    id serial primary key,
    nom varchar(255) not null,
    pays varchar(255)
);

create table vol (
    id serial primary key,
    id_avion int references avion(id),
    date_depart timestamp not null,
    duree decimal(10, 2),
    heure_reservation_avant_vol int,
    heure_annulation_reservation_avant_vol int
);

create table vol_ville (
    id_vol int references vol(id),
    id_ville int references ville_desservie(id)
);

create table promotion_vol (
    id_vol int references vol(id),
    id_type_siege int references type_siege(id),
    nombre_place int not null,
    pourcentage decimal(10, 2),
    date_promotion timestamp not null
);

create table statut (
    id serial primary key,
    libelle varchar(255)
);

create table reservation (
    id serial primary key,
    id_user int references users(id),
    id_vol int references vol(id),
    date_reservation timestamp
);

create table reservation_etat (
    id_reservation int references reservation(id),
    id_statut int references statut(id),
    id_type_siege int references type_siege(id),
    nombre_place int not null,
    daty timestamp
);