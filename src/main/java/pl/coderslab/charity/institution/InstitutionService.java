package pl.coderslab.charity.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.donation.DonationRepository;

import java.util.List;

@Service
@Transactional
public class InstitutionService {
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    public Institution findOne(Long id){
        return institutionRepository.getOne(id);
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public long sumOfInstitutions() {
        List<Integer> numberOfDonatedInstitutions = donationRepository.findAllDonatedInstitutions();
        long sum = numberOfDonatedInstitutions.stream().distinct().count();
        return sum;
    }
}
