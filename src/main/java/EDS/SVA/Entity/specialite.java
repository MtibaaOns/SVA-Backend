package EDS.SVA.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "specialite")
public class specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer codeSpec;
    @Column(name = "libSpec")
    private String libSpec;
    public specialite() {
        // Constructeur par défaut requis par JPA
    }

    public specialite(String libSpec) {
        this.libSpec = libSpec;
    }
    public Integer getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(Integer codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getLibSpec() {
        return libSpec;
    }

    public void setLibSpec(String libSpec) {
        this.libSpec = libSpec;
    }
    @Override
    public String toString() {
        return "specialite{" +
                "codeSpec=" + codeSpec +
                ", libSpec='" + libSpec + '\'' +

                '}';
    }
}


