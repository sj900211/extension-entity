package run.freshr.domain.account.entity;

import static jakarta.persistence.EnumType.STRING;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static lombok.AccessLevel.PROTECTED;
import static run.freshr.domain.account.enumerations.AccountStatus.WITHDRAWAL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import run.freshr.common.enumerations.Gender;
import run.freshr.common.extensions.entity.EntityLogicalExtension;
import run.freshr.domain.account.enumerations.AccountStatus;
import run.freshr.domain.auth.enumerations.Privilege;

@Slf4j
@Entity
@Document(indexName = "account-info")
@Table(
    schema = "account",
    name = "ACCOUNT_INFO",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_ACCOUNT_INFO_USERNAME", columnNames = {"username"}),
        @UniqueConstraint(name = "UK_ACCOUNT_INFO_NICKNAME", columnNames = {"nickname"})
    },
    indexes = {
        @Index(name = "IDX_ACCOUNT_INFO_PRIVILEGE", columnList = "privilege"),
        @Index(name = "IDX_ACCOUNT_INFO_DEFAULT_FLAG", columnList = "useFlag, deleteFlag"),
        @Index(name = "IDX_ACCOUNT_INFO_DEFAULT_AT", columnList = "createAt")
    }
)
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
@Comment("사용자 관리 > 계정 관리")
public class Account extends EntityLogicalExtension {

  @Id
  @Comment("일련 번호")
  private String id;

  @Enumerated(STRING)
  @Column(nullable = false)
  @Comment("권한")
  private Privilege privilege;

  @Enumerated(STRING)
  @Column(nullable = false)
  @Comment("상태")
  private AccountStatus status;

  @Enumerated(STRING)
  @Comment("성별")
  private Gender gender;

  @Column(nullable = false)
  @Comment("아이디 - 이메일")
  private String username;

  @Comment("닉네임")
  private String nickname;

  @Transient
  @Comment("비밀번호")
  private String password;

  @Transient
  @Comment("이전 비밀번호")
  private String previousPassword;

  @Transient
  @Comment("최근 접속 날짜 시간")
  private LocalDateTime signAt;

  @Transient
  @Comment("탈퇴 날짜 시간")
  private LocalDateTime removeAt;

  @Builder
  public Account(String id, Privilege privilege, AccountStatus status, Gender gender,
      String username, String nickname, String password) {
    this.id = id;
    this.privilege = privilege;
    this.status = status;
    this.gender = gender;
    this.username = username;
    this.nickname = nickname;
    this.password = password;
    this.previousPassword = password;
  }

  public void updateEntity(Gender gender, String nickname) {
    this.gender = gender;
    this.nickname = nickname;
  }

  public void signed() {
    this.signAt = now();
  }

  public void changePassword(String password) {
    this.previousPassword = this.password;
    this.password = password;
  }

  public void changePrivilege(Privilege privilege) {
    this.privilege = privilege;
  }

  public void changeStatus(AccountStatus status) {
    this.status = status;
  }

  public void withdrawal() {
    this.username = now().format(ofPattern("yyyyMMddHHmmss")) + "-W-" + this.username;
    this.removeAt = now();
    this.status = WITHDRAWAL;
    this.password = null;
    this.previousPassword = null;
    this.nickname = null;
    this.gender = null;

    remove();
  }

}
