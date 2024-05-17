package fr.esaip.ir4;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="DATE_DEBUT")
    private Date DATE_DEBUT;
    @Column(name="DATE_FIN")
    private Date DATE_FIN;

    @Column(name="DELAI")
    private int DELAI;

    @ManyToOne
    @JoinColumn(name="ID")
    private Client client;



}
