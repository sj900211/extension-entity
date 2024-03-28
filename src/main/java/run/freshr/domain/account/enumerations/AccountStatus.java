package run.freshr.domain.account.enumerations;

import run.freshr.common.mappers.EnumModel;

public enum AccountStatus implements EnumModel {

  INACTIVE("비활성"),
  ACTIVE("활성"),
  WITHDRAWAL("탈퇴");

  private final String value;

  AccountStatus(String value) {
    this.value = value;
  }

  @Override
  public String getKey() {
    return name();
  }

  @Override
  public String getValue() {
    return value;
  }

}
