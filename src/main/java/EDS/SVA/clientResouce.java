package EDS.SVA;
import EDS.SVA.Entity.client;
import EDS.SVA.service.clientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Clients")

public class clientResouce {
    private final clientService clientService;


    public clientResouce(clientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("all")
    public ResponseEntity<List<client>> getAllClients(){
        List<client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<client> getClientById(@PathVariable("id")Long id){
        client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<client> addClient(@RequestBody client client ){
        client newClient = clientService.addClient(client) ;
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);}
    @PutMapping("/update/{id}")
    public ResponseEntity<client> updateClient(@RequestBody client client, @PathVariable Long id,@RequestParam String nom,@RequestParam String prenom, @RequestParam String raisonSocial,@RequestParam String adresse,@RequestParam String email,@RequestParam String mf) {
        client updateClient = clientService.updateClient(client, id,nom,prenom, raisonSocial,adresse,email,mf);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteClient(@PathVariable("id")Long id){
        clientService.deleteClient(id) ;
        return new ResponseEntity<>(HttpStatus.OK);

    }













}
