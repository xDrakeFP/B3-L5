package entities;


import jakarta.persistence.*;

@Entity
@Table
@DiscriminatorValue("LIBRO")
@PrimaryKeyJoinColumn(name ="id")
public class Libro extends Media {
    @Column
    private String autore;

    @Column
    private String genere;

    public Libro(){}

    public Libro(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, String genere, String autore) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.genere = genere;
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
