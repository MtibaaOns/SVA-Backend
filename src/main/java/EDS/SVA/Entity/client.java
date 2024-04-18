package EDS.SVA.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "client")
public class client implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "RaisonSocial")
    private String raisonSocial;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Email")
    private String email;

    @Column(name = "MF")
    private String mf;

    public client() {
        // Constructeur par défaut requis par JPA
    }

    public client(String raisonSocial,String nom,String prenom, String adresse, String email,String mf) {
        this.nom = nom;
        this.prenom = prenom;
        this.raisonSocial = raisonSocial;
        this.adresse = adresse;
        this.email = email;
        this.mf = mf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getMf() {
        return mf;
    }

    public void setMp(String mf) {
        this.mf = mf;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", raisonSocial='" + raisonSocial + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", mf='" + mf + '\'' +
                '}';
    }
}