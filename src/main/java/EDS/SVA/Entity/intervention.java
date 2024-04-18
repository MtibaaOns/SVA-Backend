package EDS.SVA.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "intervention")
public class intervention {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long codeinterv;

    @Column(name = "datedebinterv")
    private String datedebinterv;

    @Column(name = "datefininterv")
    private String datefininterv;

    @Column(name = "dureeinterv")
    private String dureeinterv;

    @Column(name = "observationinterv")
    private String observationinterv;

    @Column(name = "clotureinterv")
    private String clotureinterv;

    public intervention() {
        // Constructeur par défaut requis par JPA
    }

    public intervention(String datedebinterv, String datefininterv, String dureeinterv, String observationinterv, String clotureinterv) {
        this.datedebinterv = datedebinterv;
        this.datefininterv = datefininterv;
        this.dureeinterv = dureeinterv;
        this.observationinterv = observationinterv;
        this.clotureinterv = clotureinterv;
    }

    public Long getCodeinterv() {
        return codeinterv;
    }

    public void setCodeinterv(Long codeinterv) {
        this.codeinterv = codeinterv;
    }

    public String getDatedebinterv() {
        return datedebinterv;
    }

    public void setDatedebinterv(String datedebinterv) {
        this.datedebinterv = datedebinterv;
    }

    public String getDatefininterv() {
        return datefininterv;
    }

    public void setDatefininterv(String datefininterv) {
        this.datefininterv = datefininterv;
    }

    public String getDureeinterv() {
        return dureeinterv;
    }

    public void setDureeinterv(String dureeinterv) {
        this.dureeinterv = dureeinterv;
    }

    public String getObservationinterv() {
        return observationinterv;
    }

    public void setObservationinterv(String email) {
        this.observationinterv = observationinterv;
    }

    public String getClotureinterv() {
        return clotureinterv;
    }

    public void setClotureinterv(String clotureinterv) {
        this.clotureinterv = clotureinterv;
    }



    @Override
    public String toString() {
        return "intervention{" +
                "codeinterv=" + codeinterv +
                ", datedebinterv='" + datedebinterv + '\'' +
                ", datefininterv='" + datefininterv + '\'' +
                ", dureeinterv='" + dureeinterv + '\'' +
                ", observationinterv='" + observationinterv + '\'' +
                ", cloturerinterv='" + clotureinterv + '\'' +
                '}';
    }

}
