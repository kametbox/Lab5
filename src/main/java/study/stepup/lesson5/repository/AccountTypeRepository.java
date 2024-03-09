package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
}
