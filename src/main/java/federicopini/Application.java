package federicopini;

import dao.MediaDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import entities.*;
import enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("B3-L5");
            EntityManager em = emf.createEntityManager();

            MediaDao mediaDao = new MediaDao(em);
            PrestitoDao prestitoDao = new PrestitoDao(em);
            UtenteDao utenteDao = new UtenteDao(em);

            Scanner sc = new Scanner(System.in);
            int sel;

//            Libro libro1 = new Libro("978-0132350884", "Clean Code", 2008, 464, "Software", "Robert C. Martin");
//            Libro libro2 = new Libro("978-0321356680", "Effective Java", 2018, 416, "Software", "Joshua Bloch");
//            Libro libro3 = new Libro("978-8804506923", "Il Nome della Rosa", 1980, 512, "Giallo storico", "Umberto Eco");
//            Libro libro4 = new Libro("978-8804668232", "La Divina Commedia", 1321, 800, "Poesia", "Dante Alighieri");
//            Libro libro5 = new Libro("978-0261103573", "Il Signore degli Anelli", 1954, 1200, "Fantasy", "J. R. R. Tolkien");
//
//            mediaDao.save(libro1);
//            mediaDao.save(libro2);
//            mediaDao.save(libro3);
//            mediaDao.save(libro4);
//            mediaDao.save(libro5);
//
//            Rivista rivista1 = new Rivista("977-00331484", "National Geographic", 2025, 120, Periodicita.MENSILE);
//            Rivista rivista2 = new Rivista("977-00130815", "The Economist", 2025, 90, Periodicita.SETTIMANALE);
//            Rivista rivista3 = new Rivista("977-00481234", "Wired Italia", 2025, 100, Periodicita.MENSILE);
//            Rivista rivista4 = new Rivista("977-00224567", "Nature", 2025, 80, Periodicita.SETTIMANALE);
//            Rivista rivista5 = new Rivista("977-00993421", "Focus Storia", 2025, 110, Periodicita.SEMESTRALE);
//
//            mediaDao.save(rivista1);
//            mediaDao.save(rivista2);
//            mediaDao.save(rivista3);
//            mediaDao.save(rivista4);
//            mediaDao.save(rivista5);
//
//
//            Utente utente1 = new Utente("Mario", "Rossi", LocalDate.of(1990, 5, 20), 1);
//            Utente utente2 = new Utente("Luca", "Bianchi", LocalDate.of(1985, 3, 10), 2);
//            Utente utente3 = new Utente("Sara", "Verdi", LocalDate.of(1992, 7, 15), 3);
//            Utente utente4 = new Utente("Anna", "Neri", LocalDate.of(1998, 12, 1), 4);
//            Utente utente5 = new Utente("Paolo", "Gialli", LocalDate.of(2000, 9, 9), 5);
//
//            utenteDao.save(utente1);
//            utenteDao.save(utente2);
//            utenteDao.save(utente3);
//            utenteDao.save(utente4);
//            utenteDao.save(utente5);
//
//            Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.now().minusDays(5));
//            Prestito prestito2 = new Prestito(utente2, libro2, LocalDate.now().minusDays(40));
//            Prestito prestito3 = new Prestito(utente3, rivista1, LocalDate.now().minusDays(10));
//            Prestito prestito4 = new Prestito(utente4, rivista2, LocalDate.now().minusDays(31));
//            Prestito prestito5 = new Prestito(utente5, libro3, LocalDate.now().minusDays(2));
//
//            prestitoDao.save(prestito1);
//            prestitoDao.save(prestito2);
//            prestitoDao.save(prestito3);
//            prestitoDao.save(prestito4);
//            prestitoDao.save(prestito5);

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Aggiunta di un elemento del catalogo");
            System.out.println("2) Rimozione di un elemento dato ISBN");
            System.out.println("3) Ricerca per ISBN");
            System.out.println("4) Ricerca per anno pubblicazione");
            System.out.println("5) Ricerca per autore");
            System.out.println("6) Ricerca per titolo o parte di esso");
            System.out.println("7) Ricerca prestiti attivi per tessera");
            System.out.println("8) Ricerca prestiti scaduti e non restituiti");
            System.out.println("0) Esci");

            sel = sc.nextInt(); sc.nextLine();

            switch (sel) {
                case 1 -> {
                    System.out.println("Aggiungiamo un elemento");
                    System.out.println("1: Libro - 2: Rivista");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Titolo: ");
                    String titolo = sc.nextLine();

                    System.out.println("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.println("Anno Pubblicazione: ");
                    int anno = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Numero Pagine: ");
                    int pagine = sc.nextInt();
                    sc.nextLine();

                    if(tipo == 1) {
                        System.out.println("Autore");
                        String autore = sc.nextLine();

                        System.out.println("Genere :");
                        String genere = sc.nextLine();

                        Libro l = new Libro(isbn, titolo, anno, pagine, genere, autore);
                        mediaDao.save(l);
                        System.out.println("Aggiunto libro: " + l.getTitolo());
                    } else if(tipo == 2)
                    {
                        System.out.print("Periodicita (SETTIMANALE/MENSILE/SEMESTRALE): ");
                        String p = sc.nextLine().toUpperCase();
                        Periodicita periodicita = Periodicita.valueOf(p);
                        Rivista r = new Rivista(isbn,titolo,anno,pagine,periodicita);
                        mediaDao.save(r);

                    } else {
                        System.out.println("Scelta non valida (1 o 2)");
                    }


                }
                case 2 -> {
                    System.out.println("Inserisci ISBN del media da cancellare");

                    String isbn = sc.nextLine();
                    Optional<Media> found = mediaDao.findByIsbn(isbn);
                    if (found.isEmpty()) {
                        System.out.println("Nessun elemento trovato con ISBN inserito");

                    } else {
                        try {
                            mediaDao.removeById(found.get().getId());
                            System.out.println(found.get().getTitolo() + " rimosso correttamente");
                        } catch (IllegalStateException ex) {
                            System.out.println("Immpossibile rimuoevere "+found.get().getTitolo()+" , ci sono prestiti collegati al momento");
                        }
                    }

                }
                case 3 -> {
                    System.out.println("Inserisci ISBN da ricercare");
                    String isbn = sc.nextLine();
                    Optional<Media> found = mediaDao.findByIsbn(isbn);
                    if(found.isEmpty()) {
                        System.out.println("Nessun elemento trovato con ISBN inserito");
                    } else {
                        System.out.println("Trovato :"+ found.get());
                    }
                }

                case 4 -> {
                    System.out.println("Inserisci l'anno");
                    int anno = sc.nextInt();
                    sc.nextLine();

                    List<Media> list = mediaDao.findByAnno(anno);
                    if(list.isEmpty()) {
                        System.out.println("Nessun elemento pubblicato nel "+anno);
                    } else {
                        list.forEach(m -> System.out.println(m.toString()));
                        System.out.println("Totale libri per "+anno+" :"+list.size());
                    }
                }
                case 5 -> {
                    System.out.println("Inserisci l'autore");
                    String autore = sc.nextLine();

                    List<Libro> list = mediaDao.findByAutore(autore);
                    if(list.isEmpty()) {
                        System.out.println("Nessun libro trovato per "+autore);
                    } else {
                        list.forEach(l -> System.out.println(l.toString()));
                        System.out.println("Totale libri per "+autore+" :"+list.size());
                    }
                }
                case 6 -> {
                    System.out.println("Inserisci il titolo (anche parziale)");
                    String titolo = sc.nextLine();

                    List<Media> list = mediaDao.findByTitolo(titolo);
                    if(list.isEmpty()) {
                        System.out.println("Nessun libro trovato per "+ titolo);
                    } else {
                        list.forEach(m -> System.out.println(m.toString()));
                    }
                }
                case 7 -> {
                    System.out.println("Inserisci il numero della tessera");
                    int tessera = sc.nextInt();

                    List <Prestito> list = prestitoDao.prestitiAttiviPerTessera(tessera);
                    if (list.isEmpty()){
                        System.out.println("Nessun prestito all'attivo per questo utente");
                    } else {
                        list.forEach(p -> System.out.println(p.toString()));
                    }
                }

                case 8 -> {
                    System.out.println("Lista dei prestiti scaduti");
                    List <Prestito> list = prestitoDao.prestitiScaduti();
                    if (list.isEmpty()) {
                        System.out.println("Non ci sono prestiti scaduti");
                    }
                    else {
                        list.forEach(p -> System.out.println(p.toString()));
                    }
                }
                case 0 -> System.out.println("Programma in chiusura...");
                default -> System.out.println("Scelta non valida.");

            }
        } while (sel != 0);

            em.close();
            emf.close();
    }
}
