package entities;

import enums.Periodicita;
import jakarta.persistence.*;

@Entity
@Table
@DiscriminatorValue("RIVISTA")
@PrimaryKeyJoinColumn(name = "id")
public class Rivista extends Media {

    @Enumerated(EnumType.STRING)
    @Column
    private Periodicita periodicita;

    public Rivista () {}

    public Rivista(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
