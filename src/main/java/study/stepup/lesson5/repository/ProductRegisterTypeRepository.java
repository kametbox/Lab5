package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.ProductRegisterType;

@Repository
public interface ProductRegisterTypeRepository extends JpaRepository<ProductRegisterType,Integer> {
    //List<ProductRegisterType> findByClasscode_ValueAndAcctype_Value(String productClass, String accountType);
}
