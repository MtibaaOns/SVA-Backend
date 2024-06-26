package EDS.SVA.service;

import EDS.SVA.Entity.specialite;
import EDS.SVA.exception.specialiteNotFoundException;
import EDS.SVA.repo.specialiteRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class specialiteService {
    private final specialiteRepo specialiteRepo;

    @Autowired
    public specialiteService(specialiteRepo specialiteRepo) {
        this.specialiteRepo = specialiteRepo;
    }

    private static Integer idCounter2 = 0;

    public specialite addSpecialite(specialite specialite) {
        Integer newcodeSpec = generateUniquecodeSpec();
        specialite.setCodeSpec(newcodeSpec);
        return specialiteRepo.save(specialite);
    }

    private synchronized Integer generateUniquecodeSpec() {
        return ++idCounter2;
    }
    public List<specialite> findAllSpecialites(){
        return specialiteRepo.findAll();
    }
    public specialite updateSpecialite(specialite specialite, Integer codeSpec, String libSpec) {
        Optional<specialite> optionalSpecialite = specialiteRepo.findSpecialiteBycodeSpec(codeSpec);
        specialite myspecialite = optionalSpecialite.orElseThrow(() -> new specialiteNotFoundException("specialite by id " + codeSpec + " was not found"));
        myspecialite.setLibSpec(libSpec);
        return specialiteRepo.save(myspecialite);
    }
    public specialite findSpecialiteBycodeSpec(Integer codeSpec) {
        return specialiteRepo.findSpecialiteBycodeSpec(codeSpec).orElseThrow(() -> new specialiteNotFoundException("specialite by id " + codeSpec + " was not found"));
    }
    public void deleteSpecialite(Integer codeSpec){
        specialiteRepo.deleteSpecialiteByCodeSpec(codeSpec);
    }


}