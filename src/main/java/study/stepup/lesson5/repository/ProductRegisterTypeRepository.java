package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.data.ProductRegisterType;


@Repository
public interface ProductRegisterTypeRepository extends JpaRepository<ProductRegisterType,Integer> {
    //List<ProductRegisterType> findByClasscode_ValueAndAcctype_Value(String productClass, String accountType);
    //AccountType findFirstByAccountType(String accountType);
    //ProductRegisterType findFirstByAccountType_Value(String accountType);
    ProductRegisterType findFirstByProductClassCode_ValueAndAccountType_Value(String productClassCode, String accountType);

}
