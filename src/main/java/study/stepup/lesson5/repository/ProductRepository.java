package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.data.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //Product findFirstByNumber(String number);
    Product findFirstByNumber(String number);
    Product findFirstById(Integer id);

    //Product findFirstById(Integer instanceId);

//    @Query("Select p from Product p left join ProductClass c on p.classCode=c where p.id = ?1 and ?2 like concat(c.value,'%')")
//    Product findFirstByIdAndClassCode(int id1, String classCode);
}

