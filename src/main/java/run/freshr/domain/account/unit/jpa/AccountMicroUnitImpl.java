package run.freshr.domain.account.unit.jpa;

import static run.freshr.common.utils.EntityValidateUtil.validateDocumentLogical;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;
import run.freshr.common.annotations.Unit;
import run.freshr.domain.account.entity.Account;
import run.freshr.domain.account.repository.jpa.AccountMicroRepository;

@Unit
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountMicroUnitImpl implements AccountMicroUnit {

  private final AccountMicroRepository repository;

  @Profile("test")
  @Override
  @Transactional
  public String create(Account entity) {
    return repository.save(entity).getId();
  }

  @Override
  public Boolean exists(String id) {
    return repository.existsById(id);
  }

  @Override
  public Account get(String id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public Boolean present(String id) {
    return validateDocumentLogical(repository.findById(id));
  }

}
