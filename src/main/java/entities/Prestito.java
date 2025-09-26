package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "Prestito.attiviPerUtente",
                query = "select p from Prestito p where p.utente.numeroTessera = :tessera and p.dataRestituzioneEffettiva is null"),
        @NamedQuery(name = "Prestito.attivi",
                query = "select p from Prestito p where p.dataRestituzioneEffettiva is null and p.dataRestituzionePrevista < :data")
})

@Entity
@Table
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id")
    private Media media;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_retituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito (){}

    public Prestito(Utente utente, Media media, LocalDate dataInizio) {
        this.utente = utente;
        this.media = media;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public UUID getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}

