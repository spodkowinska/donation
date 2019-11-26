package pl.coderslab.charity.institution;

import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    private final InstitutionRepository institutionRepository;

}
