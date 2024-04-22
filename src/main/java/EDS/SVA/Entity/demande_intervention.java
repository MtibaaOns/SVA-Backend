package EDS.SVA.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "demande_intervention")
public class demande_intervention implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long numDem;
    private String statut;
    private String titre;
    private String priorite;
    private LocalDate dateFin;
    private LocalDate dateDeb;
    private String description;
    public demande_intervention(){

    }
    public demande_intervention(Long numDem, String statut, String titre, String priorite, LocalDate dateFin, LocalDate dateDeb, String description) {
        this.numDem = numDem;
        this.statut = statut;
        this.titre = titre;
        this.priorite = priorite;
        this.dateFin = dateFin;
        this.dateDeb = dateDeb;
        this.description = description;
    }

    public Long getNumDem() {
        return numDem;
    }


    public void setNumDem(Long numDem) {
        this.numDem = numDem;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numDem=" + numDem +
                ", statut='" + statut + '\'' +
                ", titre='" + titre + '\'' +
                ", priorite='" + priorite + '\'' +
                ", dateFin=" + dateFin +
                ", dateDeb=" + dateDeb +
                ", description='" + description + '\'' +
                '}';
    }
}
