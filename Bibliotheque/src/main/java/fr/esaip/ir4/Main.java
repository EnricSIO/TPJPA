package fr.esaip.ir4;

import jakarta.persistence.*;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-esaip");
        EntityManager em = emf.createEntityManager();

        System.out.println(emf);
        System.out.println(em);
        //Read
        Livre L = em.find(Livre.class,1);
        if (L != null) {
            System.out.println("Titre: "+L.getTitre());
            System.out.println("Auteur: "+L.getAuteur());
        }

        //Create

        Livre Lnew = new Livre();
        Lnew.setAuteur("James Clear");
        Lnew.setTitre("Atomic habits");
        EntityTransaction et = em.getTransaction();


        //Edit
        Livre Lchange = em.find(Livre.class,5);
        Lchange.setTitre("Du plaisir dans la cuisine");

        //Requête JPQL pour extraire en fonction du titre
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre= :titre", Livre.class);
        query.setParameter("titre","Germinal");
        Livre Lrequete = query.getSingleResult();
        System.out.println("Auteur livre requete: "+Lrequete.getAuteur());

        //JPQL livre en fonction de l'auteur
        TypedQuery<Livre> query2 = em.createQuery("SELECT l FROM Livre l WHERE l.auteur= :auteur", Livre.class);
        query2.setParameter("auteur","Jean-Pierre Coffe");
        Livre Lrequete2 = query2.getSingleResult();
        System.out.println("Titre livre requete 2: "+Lrequete2.getTitre());

        //Delete
        Livre Ldelete = em.find(Livre.class,8);
        if (Ldelete != null) {
            em.remove(Ldelete);
        }

        //Select tous les livres
        TypedQuery<Livre> query3 = em.createQuery("Select l FROM Livre l",Livre.class);
        List<Livre> livres = query3.getResultList();
        for (Livre liv : livres) {
            System.out.println("Résultats query all: "+"Auteur: "+liv.getAuteur()+" Titre: "+liv.getTitre());
        }

        et.begin();
        em.persist(Lnew);
        em.persist(Lchange);
        et.commit();
        em.close();
        emf.close();
    }
}