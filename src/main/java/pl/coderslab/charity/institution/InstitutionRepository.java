package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//TODO czy warto pisać repository?
//TODO kiedy i gdzie ma być Transactional?
//TODO czemu app.js nie działa i czy powinnam tam coś zmieniać?

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
