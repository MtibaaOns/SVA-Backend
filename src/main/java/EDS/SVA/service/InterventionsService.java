package EDS.SVA.service;

import EDS.SVA.Entity.Interventions;
import EDS.SVA.exception.InterventionsNotFoundException;
import EDS.SVA.exception.contratNotFoundException;
import EDS.SVA.repo.InterventionsRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterventionsService {
    private final InterventionsRepo interventionsRepo;

    public InterventionsService(InterventionsRepo interventionsRepo) {
        this.interventionsRepo = interventionsRepo;
    }

    public Interventions addIntervention(Interventions intervention) {
        return interventionsRepo.save(intervention);
    }

    public List<Interventions> findAllInterventions() {
        return interventionsRepo.findAll();
    }

    public Interventions updateIntervention(Interventions intervention, Long id, String cause, Boolean facturer, Double montantHT, Boolean cloturer, LocalDate dateDeb, LocalDate dateFin, String duree, String observation, String technicien) {
        Optional<Interventions> optionalIntervention = interventionsRepo.findInterventionById(id);
        Interventions myIntervention = optionalIntervention.orElseThrow(() -> new InterventionsNotFoundException("Intervention by id " + id + " was not found"));

        myIntervention.setCause(cause);
        myIntervention.setFacturer(facturer);
        myIntervention.setMontantHT(montantHT);
        myIntervention.setCloturer(cloturer);
        myIntervention.setDateDeb(dateDeb);
        myIntervention.setDateFin(dateFin);
        myIntervention.setDuree(duree);
        myIntervention.setObservation(observation);
        myIntervention.setTechnicien(technicien);

        return interventionsRepo.save(myIntervention);
    }


    public Interventions findInterventionById(Long id){
        return interventionsRepo.findInterventionById(id)
                .orElseThrow(() -> new contratNotFoundException("Contrat by Numcontart " + id + " was not found"));
    }


    public void deleteIntervention(Long id) {
        interventionsRepo.deleteInterventionById(id);
    }
}