package EDS.SVA;



import EDS.SVA.Entity.intervention;
import EDS.SVA.service.interventionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Interventions")
public class interventionResouce {
    private final interventionService interventionService;
    public interventionResouce(interventionService interventionService) {
        this.interventionService = interventionService;
    }
    @GetMapping("all")
    public ResponseEntity<List<intervention>> getAllInterventions(){
        List<intervention> interventions = interventionService.findAllInterventions();
        return new ResponseEntity<>(interventions, HttpStatus.OK);
    }
    @GetMapping("/find/{codeinterv}")
    public ResponseEntity<intervention> getInterventionByCodeinterv(@PathVariable("codeinterv")Long codeinterv){
        intervention intervention = interventionService.findInterventionByCodeinterv(codeinterv);
        return new ResponseEntity<>(intervention, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<intervention> addIntervention(@RequestBody intervention intervention ){
        intervention newIntervention = interventionService.addIntervention(intervention) ;
        return new ResponseEntity<>(newIntervention, HttpStatus.CREATED);}
    @PutMapping("/update/{codeinterv}")
    public ResponseEntity<intervention> updateIntervention(@RequestBody intervention intervention, @PathVariable Long codeinterv, @RequestParam String datefininterv,@RequestParam String datedebinterv,@RequestParam String dureeinterv,@RequestParam String observationinterv,@RequestParam String clotureinterv) {
        intervention updateIntervention = interventionService.updateIntervention(intervention, codeinterv, datedebinterv,datefininterv,dureeinterv,observationinterv,clotureinterv);
        return new ResponseEntity<>(updateIntervention, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{codeinterv}")
    public  ResponseEntity<?> deleteIntervention(@PathVariable("codeinterv")Long codeinterv){
        interventionService.deleteIntervention(codeinterv); ;
        return new ResponseEntity<>(HttpStatus.OK);

    }













}
