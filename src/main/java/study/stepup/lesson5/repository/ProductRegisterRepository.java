package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.ProductRegister;

@Repository
public interface ProductRegisterRepository extends JpaRepository<ProductRegister,Integer> {
    //ProductRegister findFirstByProduct_idAndType_value(int product, String type);
}
