package entities;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "media_type")
public class Media {
    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    private String isbn;

    @Column
    private String titolo;

    @Column (name="anno_pubblicazione")
    private Integer annoPubblicazione;

    @Column (name="num_pagine")
    private Integer numeroPagine;

    public Media(){}

    public Media(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
