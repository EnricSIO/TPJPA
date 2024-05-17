package Banque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-banque");
        EntityManager em = emf.createEntityManager();

        System.out.println("emf " + emf);
        System.out.println("em " + em);

        Adresse adresse = new Adresse();
        adresse.setNumero(123);
        adresse.setRue("rue de l'Exemple");
        adresse.setCodePostal(75000);
        adresse.setVille("Paris");


        Banque banque = new Banque();
        banque.setNom("Banque de Test");

        Client client = new Client();
        client.setNom("Dupont");
        client.setPrenom("Jean");
        client.setDateNaissance(LocalDate.of(1980, Month.JANUARY, 1));
        client.setAdresse(adresse);

        Operation operation = new Operation();
        operation.setDate(LocalDateTime.now());
        operation.setMontant(150.0);
        operation.setMotif("Dépôt");
        operation.setCompte(compte);


        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(banque);
        em.persist(client);
        em.persist(compte);
        em.persist(operation);
        et.commit();
        em.close();
        emf.close();

    }
}