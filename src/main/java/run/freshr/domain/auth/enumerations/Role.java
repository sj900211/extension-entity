package run.freshr.domain.auth.enumerations;

import static java.util.Arrays.stream;

import java.util.Arrays;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import run.freshr.common.mappers.EnumModel;

/**
 * 권한 데이터 관리
 *
 * @author FreshR
 * @apiNote 권한 데이터 관리
 * @since 2024. 3. 28. 오후 3:01:53
 */
@Slf4j
public enum Role implements EnumModel {

  ROLE_MANAGER_MAJOR("시스템 관리자", Privilege.MANAGER_MAJOR, true),
  ROLE_MANAGER_MINOR("관리자", Privilege.MANAGER_MINOR, true),
  ROLE_USER("사용자", Privilege.USER, false),
  ROLE_ANONYMOUS("게스트", Privilege.ANONYMOUS, false);

  private final String value;
  @Getter
  private final Privilege privilege;
  @Getter
  private final Boolean isManager;

  Role(String value, Privilege privilege, Boolean isManager) {
    this.value = value;
    this.privilege = privilege;
    this.isManager = isManager;
  }

  @Override
  public String getKey() {
    return name();
  }

  @Override
  public String getValue() {
    return value;
  }

  /**
   * 권한 목록 정의
   *
   * @author FreshR
   * @apiNote Annotation 에서 사용하기 위해 권한 name 을 불변 속성으로 정의
   * @since 2024. 3. 28. 오후 3:01:53
   */
  public static class Secured {
    public static final String MANAGER_MAJOR = "ROLE_MANAGER_MAJOR";
    public static final String MANAGER_MINOR = "ROLE_MANAGER_MINOR";
    public static final String USER = "ROLE_USER";
    public static final String ANONYMOUS = "ROLE_ANONYMOUS";
  }

}
