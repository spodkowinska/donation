package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findAll();
}
