package Banque;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@DiscriminatorValue("AssuranceVie")
public class AssuranceVie extends Compte {
    private double taux;
    private String dateExpiration;

    // Constructeurs, getters et setters
    public AssuranceVie() {}

    public AssuranceVie(double solde, double taux, String dateExpiration) {
        super(solde);
        this.taux = taux;
        this.dateExpiration = dateExpiration;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
