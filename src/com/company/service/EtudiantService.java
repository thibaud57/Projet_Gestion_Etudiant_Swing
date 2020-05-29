package com.company.service;

import com.company.classes.Etudiant;
import com.company.dao.IDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EtudiantService implements IDao<Etudiant> {

    private ArrayList<Etudiant> liste;
    public EtudiantService() {
        liste = new ArrayList<Etudiant>();

    }

    @Override
    public boolean create(Etudiant e) {
        return liste.add(e);
    }

    @Override
    public boolean delete(Etudiant e) {
        return liste.remove(e);
    }

    @Override
    public boolean update(Etudiant etudiant, String nom, String prenom, char sexe, String filiere) {
        for(Etudiant e : liste) {
            if(e.getId() == etudiant.getId()) {
                e.setNom(nom);
                e.setPrenom(prenom);
                e.setSexe(sexe);
                e.setFiliere(filiere);
                return true;
            }
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        Iterator<Etudiant> it = liste.iterator();
        while(it.hasNext()) {
            Etudiant e = it.next();
            if(e.getId() == id) {
                return e;
            }
        }
        return null;    }

    @Override
    public List<Etudiant> findAll() {
        return liste;
    }
}


