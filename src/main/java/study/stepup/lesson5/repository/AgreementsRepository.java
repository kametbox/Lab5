package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.data.Agreement;
import study.stepup.lesson5.model.data.Product;

@Repository
public interface AgreementsRepository extends JpaRepository<Agreement,Integer> {
    //Agreements findFirstByNumber(String number);
    Agreement findFirstByProductAndNumber(Product product, String number);

}
