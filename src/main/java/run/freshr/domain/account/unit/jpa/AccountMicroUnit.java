package run.freshr.domain.account.unit.jpa;

import run.freshr.common.extensions.unit.UnitDefaultExtension;
import run.freshr.domain.account.entity.Account;

public interface AccountMicroUnit extends UnitDefaultExtension<Account, String> {

  Boolean present(String id);

}
