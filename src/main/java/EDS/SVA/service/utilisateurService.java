package EDS.SVA.service;

import EDS.SVA.Entity.utilisateur;

import EDS.SVA.exception.UtilisateurNotFoundException;
import EDS.SVA.repo.utilisateurRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class utilisateurService {
    private final utilisateurRepo utilisateurRepo;
    @Autowired
    public utilisateurService(utilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }
    private static long idCounter = 0;
    public utilisateur addUtilisateur(utilisateur utilisateur) {
        long newId = generateUniqueId();
        utilisateur.setId(newId);
        return utilisateurRepo.save(utilisateur);
    }
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }
    public List<utilisateur> findAllUtilisateurs(){
        return utilisateurRepo.findAll();
    }
    public utilisateur updateUtilisateur(utilisateur utilisateur, Long id, String nom, String prenom,String adresse,String tel,String email,String login,String mp,String role) {
        Optional<utilisateur> optionalUtilisateur = utilisateurRepo.findUtilisateurById(id);

        utilisateur myutilisateur = optionalUtilisateur.orElseThrow(() -> new UtilisateurNotFoundException("utilisateur by id " + id + " was not found"));


        myutilisateur.setNom(nom);
        myutilisateur.setPrenom(prenom);
        myutilisateur.setAdresse(adresse);
        myutilisateur.setEmail(email);
        myutilisateur.setTel(tel);
        myutilisateur.setMt(mp);
        myutilisateur.setLogin(login);
        myutilisateur.setRole(role);
        // Vous pouvez également mettre à jour d'autres propriétés si nécessaire

        return utilisateurRepo.save(myutilisateur);
    }
    public utilisateur findUtilisateurById(Long id){
        return utilisateurRepo.findUtilisateurById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("utilisateur by id " + id + " was not found"));
    }
    public void deleteUtilisateur(Long id){
        utilisateurRepo.deleteUtilisateurById(id);
    }
}









