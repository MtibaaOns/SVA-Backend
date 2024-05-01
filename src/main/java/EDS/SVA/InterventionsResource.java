package EDS.SVA;

import EDS.SVA.Entity.Interventions;
import EDS.SVA.service.InterventionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Interventions")
public class InterventionsResource {
    private final InterventionsService interventionsService;

    public InterventionsResource(InterventionsService interventionsService) {
        this.interventionsService = interventionsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interventions>> getAllInterventions() {
        List<Interventions> interventions = interventionsService.findAllInterventions();
        return new ResponseEntity<>(interventions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Interventions> getInterventionById(@PathVariable("id") Long id) {
        Interventions intervention = interventionsService.findInterventionById(id);
        return new ResponseEntity<>(intervention, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Interventions> addIntervention(@RequestBody Interventions intervention) {
        Interventions newIntervention = interventionsService.addIntervention(intervention);
        return new ResponseEntity<>(newIntervention, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Interventions> updateIntervention(@RequestBody Interventions intervention, @PathVariable Long id, @RequestParam String cause, @RequestParam Boolean facturer, @RequestParam Double montantHT, @RequestParam Boolean cloturer, @RequestParam LocalDate dateDeb, @RequestParam LocalDate dateFin, @RequestParam String duree, @RequestParam String observation) {
        Interventions updatedIntervention = interventionsService.updateIntervention(intervention, id, cause, facturer, montantHT, cloturer, dateDeb, dateFin, duree, observation);
        return new ResponseEntity<>(updatedIntervention, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIntervention(@PathVariable("id") Long id) {
        interventionsService.deleteIntervention(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}