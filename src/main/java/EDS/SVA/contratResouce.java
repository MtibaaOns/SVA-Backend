package EDS.SVA;

import EDS.SVA.Entity.contrat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import EDS.SVA.service.contratService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Contrats")
public class contratResouce {
    private final contratService contratService;

    public contratResouce(contratService contratService) {
        this.contratService = contratService;
    }
    @GetMapping("all")
    public ResponseEntity<List<contrat>> getAllContrats(){
        List<contrat> contrats = contratService.findAllContrats();
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("/find/{numcontart}")
    public ResponseEntity<contrat> getContratBynumcontrat(@PathVariable("numcontart")Long numcontart){
        contrat contrat = contratService.findContratBynumcontart(numcontart);
        return new ResponseEntity<>(contrat, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<contrat> addContrat(@RequestBody contrat contrat ){
        contrat newContrat = contratService.addContrat(contrat) ;
        return new ResponseEntity<>(newContrat, HttpStatus.CREATED);}
    @PutMapping("/update/{numcontart}")
    public ResponseEntity<contrat> updateContrat(@RequestBody contrat contrat, @PathVariable Long numcontart, @PathVariable LocalDate dateDebut,@PathVariable LocalDate dateFin,@PathVariable Integer nbInterMois,@PathVariable Integer nbInterAnnee,@PathVariable Long mtForfaitaire) {
        contrat updateContrat = contratService.updateContrat(contrat, numcontart,dateDebut,dateFin, nbInterMois,nbInterAnnee,mtForfaitaire);
        return new ResponseEntity<>(updateContrat, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{numcontart}")
    public  ResponseEntity<?> deleteContrat(@PathVariable("numcontart")Long numcontart){
        contratService.deleteContrat(numcontart); ;
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

