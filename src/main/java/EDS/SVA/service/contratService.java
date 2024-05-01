package EDS.SVA.service;

import EDS.SVA.Entity.contrat;


import EDS.SVA.exception.contratNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import EDS.SVA.repo.contratRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class contratService {
    private final contratRepo contratRepo;

    public contratService(EDS.SVA.repo.contratRepo contratRepo) {
        this.contratRepo = contratRepo;
    }

    private static long idCounter = 0;

    public contrat addContrat(contrat contrat) {
        Long newNumcontart = generateUniquenumcontrat();
        contrat.setNumcontrat(newNumcontart);
        return contratRepo.save(contrat);
    }

    private synchronized long generateUniquenumcontrat() {
        return ++idCounter;
    }

    public List<contrat> findAllContrats() {
        return contratRepo.findAll();
    }

    public contrat updateContrat(contrat contrat, Long numcontart, LocalDate dateDebut, LocalDate dateFin, Integer nbInterMois, Integer nbInterAnnee, Double mtForfaitaire,String client) {
        Optional<contrat> optionalContrat = contratRepo.findContratBynumcontrat(numcontart);
        contrat myContrat = optionalContrat.orElseThrow(() -> new contratNotFoundException("Contrat by id " + numcontart + " was not found"));

        myContrat.setDateDebut(dateDebut);
        myContrat.setDateFin(dateFin);
        myContrat.setMtForfaitaire(mtForfaitaire);
        myContrat.setNbInterAnnee(nbInterAnnee);
        myContrat.setNbInterMois(nbInterMois);
        myContrat.setClient(client);


        return contratRepo.save(myContrat);

    }

    public contrat findContratBynumcontart(Long numcontart){
        return contratRepo.findContratBynumcontrat(numcontart)
                .orElseThrow(() -> new contratNotFoundException("Contrat by Numcontart " + numcontart + " was not found"));
    }


    public void deleteContrat(Long numcontart){
        contratRepo.deleteContratBynumcontrat(numcontart);
    }

}
