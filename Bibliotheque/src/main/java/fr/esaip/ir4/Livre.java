package fr.esaip.ir4;

import jakarta.persistence.*;

@Entity
@Table(name="LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="AUTEUR",nullable=false)
    private String auteur;

    @Column (name="TITRE",nullable = false)
    private String titre;

    public int getId() {
        return id;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
