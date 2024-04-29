package EDS.SVA.service;

import EDS.SVA.Entity.Interventions;
import EDS.SVA.exception.InterventionsNotFoundException;
import EDS.SVA.repo.InterventionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterventionsService {

    private final InterventionsRepo interventionRepo;

    @Autowired
    public InterventionsService(InterventionsRepo interventionRepo) {
        this.interventionRepo = interventionRepo;
    }

    /**
     * Ajoute une nouvelle intervention
     */
    public Interventions addIntervention(Interventions intervention) {
        return interventionRepo.save(intervention);
    }

    /**
     * Récupère toutes les interventions
     */
    public List<Interventions> findAllInterventions() {
        return interventionRepo.findAll();
    }

    /**
     * Met à jour une intervention existante
     */
    public Interventions updateIntervention(Interventions intervention, Long id, java.time.LocalDate dateDeb, java.time.LocalDate dateFin, java.time.Duration duree, String observation, boolean cloturer, double MontantHT, boolean facturer, String cause) {
        Optional<Interventions> optionalIntervention = interventionRepo.findById(id);
        Interventions myIntervention = optionalIntervention.orElseThrow(() -> new InterventionsNotFoundException("Intervention by id " + id + " was not found"));
        myIntervention.setDateDeb(dateDeb);
        myIntervention.setDateFin(dateFin);
        myIntervention.setDuree(duree);
        myIntervention.setObservation(observation);
        myIntervention.setCloturer(cloturer);
        myIntervention.setMontantHT(MontantHT);
        myIntervention.setFacturer(facturer);
        myIntervention.setCause(cause);
        return interventionRepo.save(myIntervention);
    }

    /**
     * Récupère une intervention par son identifiant
     */
    public Interventions findInterventionById(Long id) {
        return interventionRepo.findById(id)
                .orElseThrow(() -> new InterventionsNotFoundException("Intervention by id " + id + " was not found"));
    }

    /**
     * Supprime une intervention par son identifiant
     */
    public void deleteIntervention(Long id) {
        interventionRepo.deleteById(id);
    }
}