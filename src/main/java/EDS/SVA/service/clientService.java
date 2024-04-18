package EDS.SVA.service;
import EDS.SVA.Entity.client;
import EDS.SVA.exception.clientNotFoundException;
import EDS.SVA.repo.clientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class clientService {
    private final clientRepo clientRepo;
    @Autowired
    public clientService(clientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }
    private static long idCounter = 0;
    public client addClient(client client) {
        long newId = generateUniqueId();
        client.setId(newId);
        return clientRepo.save(client);
    }
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }
    public List<client> findAllClients(){
        return clientRepo.findAll();
    }
    public client updateClient(client client, Long id, String nom, String prenom, String raisonSocial, String email,String adresse,String mf) {
        Optional<client> optionalClient = clientRepo.findClientById(id);
        client myClient = optionalClient.orElseThrow(() -> new clientNotFoundException("Client by id " + id + " was not found"));

        myClient.setAdresse(nom);
        myClient.setAdresse(prenom);
        myClient.setRaisonSocial(raisonSocial);
        myClient.setAdresse(adresse);
        myClient.setEmail(email);
        myClient.setMp(mf);
        // Vous pouvez également mettre à jour d'autres propriétés si nécessaire

        return clientRepo.save(myClient);
    }
    public client findClientById(Long id){
        return clientRepo.findClientById(id)
                .orElseThrow(() -> new clientNotFoundException("Client by id " + id + " was not found"));
    }
    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);
    }
}








