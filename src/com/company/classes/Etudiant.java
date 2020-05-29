package com.company.classes;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private char sexe;
    private String filiere;
    private static int cpt;


    public Etudiant(int id, String nom, String prenom, char sexe, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }

    public Etudiant(String nom, String prenom, char sexe, String filiere) {
        id = cpt ++;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.filiere = filiere;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public static int getCpt() {
        return cpt;
    }

    public static void setCpt(int cpt) {
        Etudiant.cpt = cpt;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe=" + sexe +
                ", filiere='" + filiere + '\'' +
                '}';
    }
}
