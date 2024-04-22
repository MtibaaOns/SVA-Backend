package EDS.SVA.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "contrat")
public class contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )


    private Long numcontrat;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer nbInterMois;
    private Integer nbInterAnnee;
    private Long mtForfaitaire;
    public  contrat(){

    }

    public contrat(Long numcontrat, LocalDate dateDebut, LocalDate dateFin, Integer nbInterMois, Integer nbInterAnnee, Long mtForfaitaire) {
        this.numcontrat = numcontrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbInterMois = nbInterMois;
        this.nbInterAnnee = nbInterAnnee;
        this.mtForfaitaire = mtForfaitaire;
    }
    public void setNumcontrat(Long numcontrat) {
        this.numcontrat = numcontrat;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbInterMois(Integer nbInterMois) {
        this.nbInterMois = nbInterMois;
    }

    public void setNbInterAnnee(Integer nbInterAnnee) {
        this.nbInterAnnee = nbInterAnnee;
    }

    public void setMtForfaitaire(Long mtForfaitaire) {
        this.mtForfaitaire = mtForfaitaire;
    }

    public Long getNumcontrat() {
        return numcontrat;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Integer getNbInterMois() {
        return nbInterMois;
    }

    public Integer getNbInterAnnee() {
        return nbInterAnnee;
    }

    public Long getMtForfaitaire() {
        return mtForfaitaire;
    }
    public String toString() {
        return "Contrat{" +
                "id=" + numcontrat +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nbInterMois=" + nbInterMois +
                ", nbInterAnnee=" + nbInterAnnee +
                ", mtForfaitaire=" + mtForfaitaire +
                '}';
    }
}
