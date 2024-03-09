package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.Agreement;

@Repository
public interface AgreementsRepository extends JpaRepository<Agreement,Integer> {
    //Agreements findFirstByNumber(String number);
}
