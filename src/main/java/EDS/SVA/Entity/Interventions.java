package EDS.SVA.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "interventions")
public class Interventions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String code;
    private LocalDate dateDeb;
    private LocalDate dateFin;
    private Duration duree;
    private String observation;
    private boolean cloturer;
    private double MontantHT;
    private boolean facturer;
    private String cause;

    public Interventions() {
    }

    public Interventions(String code, LocalDate dateDeb, LocalDate dateFin, Duration duree, String observation, boolean cloturer, double MontantHT, boolean facturer, String cause) {
        this.code = code;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.duree = duree;
        this.observation = observation;
        this.cloturer = cloturer;
        this.MontantHT = MontantHT;
        this.facturer = facturer;
        this.cause = cause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean isCloturer() {
        return cloturer;
    }

    public void setCloturer(boolean cloturer) {
        this.cloturer = cloturer;
    }

    public double getMontantHT() {
        return MontantHT;
    }

    public void setMontantHT(double MontantHT) {
        this.MontantHT = MontantHT;
    }

    public boolean isFacturer() {
        return facturer;
    }

    public void setFacturer(boolean facturer) {
        this.facturer = facturer;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDureeFormatted() {
        long minutes = duree.toMinutes();
        long hours = minutes / 60;
        minutes = minutes % 60;

        if (hours > 0 && minutes > 0) {
            return hours + " hours and " + minutes + " minutes";
        } else if (hours > 0) {
            return hours + " hours";
        } else {
            return minutes + " minutes";
        }
    }

    @Override
    public String toString() {
        return "Intervention{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", dateDeb=" + dateDeb +
                ", dateFin=" + dateFin +
                ", duree=" + duree +
                ", observation='" + observation + '\'' +
                ", cloturer=" + cloturer +
                ", MontantHT=" + MontantHT +
                ", facturer=" + facturer +
                ", cause='" + cause + '\'' +
                '}';
    }
}