package run.freshr.domain.account.dto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.freshr.common.enumerations.Gender;
import run.freshr.domain.account.enumerations.AccountStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditorData {

  private String id;
  private AccountStatus status;
  private Gender gender;
  private String username;
  private String nickname;

}
