import jakarta.persistence.*;

@Entity
public class LivretA extends Compte {
    private double taux;

    // Constructeurs, getters et setters
    public LivretA() {}

    public LivretA(double solde, double taux) {
        super(solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}