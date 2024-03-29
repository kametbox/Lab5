package study.stepup.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.stepup.lesson5.model.data.Account;
import study.stepup.lesson5.model.data.AccountPool;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findFirstByAccountPoolId(AccountPool accountPool);
}
