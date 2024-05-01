package EDS.SVA.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String adresse;
    private String login;
    private String mp;
    private String role;
    private String specialite;

    public utilisateur() {
    }

    public utilisateur(String nom, String prenom, String tel, String email, String adresse, String login, String mp, String role, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        this.login = login;
        this.mp = mp;
        this.role = role;
        this.specialite = specialite;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", login='" + login + '\'' +
                ", mot_de_passe='" + mp + '\'' +
                ", role='" + role + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}