package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//TODO czy warto pisać repository?
//TODO kiedy i gdzie ma być Transactional?



public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findAll();
}
