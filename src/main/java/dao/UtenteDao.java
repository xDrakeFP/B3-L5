package dao;


import entities.Utente;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDao {
    private EntityManager em;
    public UtenteDao(EntityManager em){this.em = em;}

    public void save(Utente utente){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(utente);
        tr.commit();
    }

    public Utente findById(UUID id){
        Utente found = em.find(Utente.class, id);
        if(found == null) throw new NotFoundException(id);
        return found;
    }

}
