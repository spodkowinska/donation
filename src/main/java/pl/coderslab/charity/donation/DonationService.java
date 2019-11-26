package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        List<Donation> donationsList = donationRepository.findAll();
//        List<Integer> quantities = new ArrayList<>();
        int sum = donationsList.stream().map(x -> x.quantity)
                .reduce(0, Integer::sum);
        return sum;
    }
}
