package run.freshr.domain.auth.enumerations;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import run.freshr.common.mappers.EnumModel;

/**
 * 권한 데이터 관리
 *
 * @author 류성재
 * @apiNote 권한 데이터 관리
 * @since 2024. 3. 28. 오후 2:59:27
 */
@Slf4j
public enum Privilege implements EnumModel {

  MANAGER_MAJOR("시스템 관리자", Role.ROLE_MANAGER_MAJOR),
  MANAGER_MINOR("관리자", Role.ROLE_MANAGER_MINOR),
  USER("사용자", Role.ROLE_USER),
  ANONYMOUS("게스트", Role.ROLE_ANONYMOUS);

  private final String value;
  @Getter
  private final Role role;

  Privilege(String value, Role role) {
    this.value = value;
    this.role = role;
  }

  @Override
  public String getKey() {
    return name();
  }

  @Override
  public String getValue() {
    return this.value;
  }

}
