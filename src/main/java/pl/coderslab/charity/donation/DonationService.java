package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class DonationService {
    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public int sumOfBags() {
        List<Integer>donationsQuantities = donationRepository.findAllQuantities();

        int sum = donationsQuantities.stream().reduce(0, Integer::sum);
        return sum;
    }
    public void save(Donation donation){
        donationRepository.save(donation);
    }


}
