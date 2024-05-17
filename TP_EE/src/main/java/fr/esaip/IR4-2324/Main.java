package fr.esaip.IR4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-esaip");
        EntityManager em = emf.createEntityManager();

        System.out.println(emf);
        System.out.println(em);
        em.close();
        emf.close();

    }
}