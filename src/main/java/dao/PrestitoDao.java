package dao;

import entities.*;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PrestitoDao {
    private EntityManager em;
    public PrestitoDao(EntityManager em) {this.em = em;}

    public void save(Prestito prestito){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(prestito);
        tr.commit();
    }

    public Prestito findById(UUID id){
        Prestito found = em.find(Prestito.class,id);
        if(found == null) throw new NotFoundException(id);
        return found;
    }

public List<Prestito> prestitiAttiviPerTessera(int tessera_id) {
        List<Prestito> found = em.createNamedQuery("Prestito.attiviPerUtente",Prestito.class).setParameter("tessera",tessera_id).getResultList();
        return found;
}
    public List<Prestito> prestitiScaduti() {
        List<Prestito> found = em.createNamedQuery("Prestito.scaduti",Prestito.class).setParameter("tessera",LocalDate.now()).getResultList();
        return found;
    }



    }
