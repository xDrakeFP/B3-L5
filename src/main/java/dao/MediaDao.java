package dao;

import entities.*;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MediaDao {
    private EntityManager em;
    public MediaDao (EntityManager em)
    {this.em = em;}

    public void save(Media media) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(media);
        tr.commit();
    }

    public Media findById(UUID id){
        Media found = em.find(Media.class, id);
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void removeById(UUID id){
    Media found = this.findById(id);
    EntityTransaction tr = em.getTransaction();
    tr.begin();
    em.remove(found);
    tr.commit();
    System.out.println(found.getTitolo()+" è stato eliminato con successo");
    }


    public Optional<Media> findByIsbn(String isbn){
        Optional<Media> found = em.createQuery("select m from Media m where m.isbn = :isbn", Media.class).setParameter("isbn", isbn).getResultStream().findFirst();
        return found;
    }

    public List<Media> findByAnno(Integer anno){
        List<Media> foundList = em.createQuery("select m from Media m where m.annoPubblicazione = :anno", Media.class).setParameter("anno",anno).getResultList();
        return foundList;
    }

    public List<Media> findByTitolo(String titolo) {
        List<Media> foundByTitle = em.createQuery("select m from Media m where m.titolo like :final", Media.class).setParameter("final","%"+titolo+"%").getResultList();
        return foundByTitle;
    }
    public List<Libro> findByAutore(String autore) {
        List<Libro> foundByAuthor = em.createQuery("select l from Libro l where l.autore like :final", Libro.class).setParameter("final","%"+autore+"%").getResultList();
        return foundByAuthor;
    }


}
