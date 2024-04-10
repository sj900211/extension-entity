package run.freshr.common.enumerations;

import run.freshr.common.mappers.EnumModel;

/**
 * 성별 데이터 관리
 *
 * @author FreshR
 * @apiNote 성별 데이터 관리
 * @since 2024. 3. 28. 오후 2:21:51
 */
public enum Gender implements EnumModel {

  MALE("남성"),
  FEMALE("여성"),
  OTHERS("그 외");

  /**
   * 설명
   *
   * @apiNote 설명
   * @since 2024. 3. 28. 오후 2:21:51
   */
  private final String value;

  /**
   * 생성자
   *
   * @param value value
   * @apiNote 생성자
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:21:51
   */
  Gender(String value) {
    this.value = value;
  }

  /**
   * 열거 데이터 이름 조회
   *
   * @return 열거 데이터 이름
   * @apiNote 열거 데이터 이름 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:21:51
   */
  @Override
  public String getKey() {
    return name();
  }

  /**
   * 열거 데이터 설명 조회
   *
   * @return 열거 데이터 설명
   * @apiNote 열거 데이터 설명 조회
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:21:51
   */
  @Override
  public String getValue() {
    return value;
  }

}
