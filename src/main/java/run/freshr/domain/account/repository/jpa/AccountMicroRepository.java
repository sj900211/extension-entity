package run.freshr.domain.account.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import run.freshr.domain.account.entity.Account;

public interface AccountMicroRepository extends JpaRepository<Account, String> {

  @Query(value = "SELECT NEXTVAL('\"account\".seq_account')")
  Long getSequence();

}
