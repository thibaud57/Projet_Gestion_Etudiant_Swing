package com.company.dao;

import java.util.List;

public interface IDao<Etudiant> {

    public boolean create(Etudiant e);

    public boolean delete(Etudiant e);

    public boolean update(Etudiant e, String nom, String prenom, char sexe, String filiere);

    public Etudiant findById(int id);

    public List<Etudiant> findAll();
}
