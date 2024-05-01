package EDS.SVA.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "facture")
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "client")
    private String client;

    @Column(name = "totalHT")
    private Double totalHT;

    @Column(name = "tva")
    private Integer tva;

    @Column(name = "totalTTC")
    private Double totalTTC;

    @Column(name = "intervention")
    private String intervention;

    public Facture() {
    }

    public Facture(String code, LocalDate date, String client, Double totalHT, Integer tva, String intervention) {
        this.code = code;
        this.date = date;
        this.client = client;
        this.totalHT = totalHT;
        this.tva = tva;
        this.intervention = intervention;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(Double totalHT) {
        this.totalHT = totalHT;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public Double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(Double totalTTC) {
        this.totalTTC = totalTTC;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", totalHT=" + totalHT +
                ", tva=" + tva +
                ", intervention='" + intervention + '\'' +
                ", totalTTC=" + totalTTC +
                '}';
    }
}