package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table

public class Utente {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String nome;

    @Column
    private String surname;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column (name ="num_tessera")
    private Integer numeroTessera;

    public Utente(){}

    public Utente(String nome, String surname, LocalDate dataNascita, int numeroTessera) {
        this.nome = nome;
        this.surname = surname;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(Integer numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", surname='" + surname + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}
