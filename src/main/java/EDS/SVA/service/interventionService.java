package EDS.SVA.service;
import EDS.SVA.Entity.intervention;
import EDS.SVA.exception.interventionNotFoundException;
import EDS.SVA.repo.interventionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;






@Service
@Transactional
public class interventionService   {
    private final interventionRepo interventionRepo;
    @Autowired
    public interventionService(interventionRepo interventionRepo) {
        this.interventionRepo = interventionRepo;
    }
    private static long idCounter = 0;
    public intervention addIntervention(intervention intervention) {
        long newCodeinterv = generateUniqueCodeinterv();
        intervention.setCodeinterv(newCodeinterv);
        return interventionRepo.save(intervention);
    }
    private synchronized long generateUniqueCodeinterv() {
        return ++idCounter;
    }
    public List<intervention> findAllInterventions(){
        return interventionRepo.findAll();
    }
    public intervention updateIntervention(intervention intervention, Long codeinterv, String datedebinterv, String datefininterv,String dureeinterv,String observationinterv,String clotureinterv) {
        Optional<intervention> optionalIntervention = interventionRepo.findInterventionByCodeinterv(codeinterv);
        intervention myintervention = optionalIntervention.orElseThrow(() -> new interventionNotFoundException("intervention by id " + codeinterv + " was not found"));


        myintervention.setDatedebinterv(datedebinterv);
        myintervention.setDatefininterv(datefininterv);
        myintervention.setDureeinterv(dureeinterv);
        myintervention.setObservationinterv(observationinterv);
        myintervention.setClotureinterv(clotureinterv);
        // Vous pouvez également mettre à jour d'autres propriétés si nécessaire

        return interventionRepo.save(myintervention);
    }
    public intervention findInterventionByCodeinterv(Long codeinterv){
        return interventionRepo.findInterventionByCodeinterv(codeinterv)
                .orElseThrow(() -> new interventionNotFoundException("Intervention by id " + codeinterv + " was not found"));
    }
    public void deleteIntervention(Long codeinterv){
        interventionRepo.deleteInterventionByCodeinterv(codeinterv);
    }
}









