package dao;

import entities.*;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class MediaDao {
    private EntityManager em;
    public MediaDao (EntityManager em)
    {this.em = em;}

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
    public List<Media> findByAutore(String autore) {
        List<Media> foundByAuthor = em.createQuery("select m from Media m where m.autore like :final", Media.class).setParameter("final","%"+autore+"%").getResultList();
        return foundByAuthor;
    }


}
