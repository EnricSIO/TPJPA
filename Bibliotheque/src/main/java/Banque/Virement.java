import jakarta.persistence.*;
import java.time.Date;

@Entity
public class Virement extends Operations {
    private String details;

    // Constructeurs, getters et setters
    public Virement() {}

    public Virement(Date dateOperation, double montant, String details) {
        super(dateOperation, montant);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}