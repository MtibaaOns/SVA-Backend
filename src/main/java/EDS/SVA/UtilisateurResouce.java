package EDS.SVA;

import EDS.SVA.Entity.specialite;
import  EDS.SVA.Entity.utilisateur;
import  EDS.SVA.service.utilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/Utilisateurs")
public class UtilisateurResouce {
    private final utilisateurService utilisateurService;

    public UtilisateurResouce(utilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<utilisateur>> getAllUtilisateurs() {
        List<utilisateur> utilisateurs = utilisateurService.findAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<utilisateur> addUtilisateur(@RequestBody utilisateur utilisateur) {
        utilisateur newUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<utilisateur> updateUtilisateur(@RequestBody utilisateur utilisateur, @PathVariable Long id, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String adresse, @RequestParam String role, @RequestParam String tel, @RequestParam String login, @RequestParam String mp, @RequestParam String specialite) {
        utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(utilisateur, id, nom,prenom,adresse,tel,email,mp,login,role,specialite);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {

        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

