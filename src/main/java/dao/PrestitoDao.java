package dao;

import entities.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {
    private EntityManager em;
    public PrestitoDao(EntityManager em) {this.em = em;}

public List<Prestito> prestitiAttiviPerTessera(String tessera_id) {
        List<Prestito> found = em.createNamedQuery("Prestito.attiviPerUtente",Prestito.class).setParameter("tessera",tessera_id).getResultList();
        return found;
}
    public List<Prestito> prestitiAttivi() {
        List<Prestito> found = em.createNamedQuery("Prestito.scadutiPerData",Prestito.class).setParameter("tessera",LocalDate.now()).getResultList();
        return found;
    }



    }
