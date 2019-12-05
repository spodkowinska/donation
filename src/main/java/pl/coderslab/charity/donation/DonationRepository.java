package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "select quantity from donations", nativeQuery = true)
    List<Integer>findAllQuantities();

    @Query(value="select institution_id from donations", nativeQuery = true)
    List <Integer>findAllDonatedInstitutions();

}
