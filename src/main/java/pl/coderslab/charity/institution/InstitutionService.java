package pl.coderslab.charity.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstitutionService {

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll(){return institutionRepository.findAll();}

    public long sumOfInstitutions(){
        List<Institution>institutionsList = findAll();
        long sum = institutionsList.stream().count();
        return sum;
    }
}
