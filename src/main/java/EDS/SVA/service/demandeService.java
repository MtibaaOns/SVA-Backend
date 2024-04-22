package EDS.SVA.service;
import EDS.SVA.Entity.demande_intervention;
import EDS.SVA.exception.clientNotFoundException;
import EDS.SVA.exception.demandeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import EDS.SVA.repo.demandeRepo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class demandeService {
    private final demandeRepo demandeRepo;
    public demandeService(EDS.SVA.repo.demandeRepo demandeRepo) {
        this.demandeRepo = demandeRepo;
    }
    private static long idCounter = 0;
    public demande_intervention addDemande(demande_intervention demandeIntervention) {
        long newNumDem = generateUniquenumDem();
        demandeIntervention.setNumDem(newNumDem);
        return demandeRepo.save(demandeIntervention);
    }

    private synchronized long generateUniquenumDem() {
        return ++idCounter;
    }
    public List<demande_intervention> findAllDemandes() {
        return demandeRepo.findAll();
    }

    public demande_intervention updateDemande(demande_intervention demande_intervention, Long numDem, String statut, String titre, String priorite, LocalDate dateFin, LocalDate dateDeb, String description) {
        Optional<demande_intervention> optionalTicket = demandeRepo.findDemandeBynumDem(numDem);
        demande_intervention myDemande = optionalTicket.orElseThrow(() -> new demandeNotFoundException("Client by id " + numDem + " was not found"));

        myDemande.setStatut(statut);
        myDemande.setTitre(titre);
        myDemande.setPriorite(priorite);
        myDemande.setDateFin(dateFin);
        myDemande.setDateDeb(dateDeb);
        myDemande.setDescription(description);

        return demandeRepo.save(myDemande);
    }


    public demande_intervention findDemandeBynumDem(Long numDem){
        return demandeRepo.findDemandeBynumDem(numDem)
                .orElseThrow(() -> new clientNotFoundException("Client by id " + numDem + " was not found"));
    }

    public void deleteTicket(Long numDem){
        demandeRepo.deleteTicketBynumDem(numDem);
    }










}



