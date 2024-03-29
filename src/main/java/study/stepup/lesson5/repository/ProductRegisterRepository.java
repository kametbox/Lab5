package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.data.ProductRegister;

@Repository
public interface ProductRegisterRepository extends JpaRepository<ProductRegister,Integer> {
    ProductRegister findFirstByProductId_Id(int id);
}
