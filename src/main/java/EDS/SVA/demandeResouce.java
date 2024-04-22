package EDS.SVA;


import EDS.SVA.Entity.demande_intervention;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import EDS.SVA.service.demandeService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("Tickets")
public class demandeResouce {
    private final demandeService demandeService;

    public demandeResouce(EDS.SVA.service.demandeService demandeService) {
        this.demandeService = demandeService;
    }
    @GetMapping("all")
    public ResponseEntity<List<demande_intervention>> getAllDemandes(){
        List<demande_intervention> demandes = demandeService.findAllDemandes();
        return new ResponseEntity<>(demandes, HttpStatus.OK);
    }
    @GetMapping("/find/{numDem}")
    public ResponseEntity<demande_intervention> getDemandeBynumDem(@PathVariable("numDem")Long numDem){
        demande_intervention demandeIntervention = demandeService.findDemandeBynumDem(numDem);
        return new ResponseEntity<>(demandeIntervention, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<demande_intervention> addDemande(@RequestBody demande_intervention demandeIntervention ){
        demande_intervention newTicket = demandeService.addDemande(demandeIntervention) ;
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);}
    @PutMapping("/update/{numDem}")
    public ResponseEntity<demande_intervention> updateDemande(@RequestBody demande_intervention demandeIntervention,@PathVariable Long numDem,@PathVariable String statut,@PathVariable String titre,@PathVariable String priorite,@PathVariable LocalDate dateFin,@PathVariable LocalDate dateDeb,@PathVariable String description) {
        demande_intervention updateTicket = demandeService.updateDemande(demandeIntervention,numDem,statut,titre,priorite,dateFin,dateDeb,description);
        return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{numDem}")
    public  ResponseEntity<?> deleteContrat(@PathVariable("numDem")Long numDem){
        demandeService.deleteTicket(numDem); ;
        return new ResponseEntity<>(HttpStatus.OK);

    }





}
