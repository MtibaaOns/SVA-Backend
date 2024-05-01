package EDS.SVA.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "intervention")
public class Interventions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String cause;
    private Boolean facturer;
    private Double montantHT;
    private Boolean cloturer;
    private LocalDate dateDeb;
    private LocalDate dateFin;
    private String code;
    private String duree;
    private String observation;
    private String technicien;

    public Interventions() {
    }

    public Interventions(String cause, Boolean facturer, Double montantHT, Boolean cloturer, LocalDate dateDeb, LocalDate dateFin, String code, String duree, String observation, String technicien) {
        this.cause = cause;
        this.facturer = facturer;
        this.montantHT = montantHT;
        this.cloturer = cloturer;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.code = code;
        this.duree = duree;
        this.observation = observation;
        this.technicien = technicien;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setFacturer(Boolean facturer) {
        this.facturer = facturer;
    }

    public Boolean getFacturer() {
        return facturer;
    }

    public void setMontantHT(Double montantHT) {
        this.montantHT = montantHT;
    }

    public Double getMontantHT() {
        return montantHT;
    }

    public void setCloturer(Boolean cloturer) {
        this.cloturer = cloturer;
    }

    public Boolean getCloturer() {
        return cloturer;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDuree() {
        return duree;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getObservation() {
        return observation;
    }

    public void setTechnicien(String technicien) {
        this.technicien = technicien;
    }

    public String getTechnicien() {
        return technicien;
    }

    public String toString() {
        return "Intervention{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", facturer=" + facturer +
                ", montantHT=" + montantHT +
                ", cloturer=" + cloturer +
                ", dateDeb=" + dateDeb +
                ", dateFin=" + dateFin +
                ", code='" + code + '\'' +
                ", duree='" + duree + '\'' +
                ", observation='" + observation + '\'' +
                ", technicien='" + technicien + '\'' +
                '}';
    }
}