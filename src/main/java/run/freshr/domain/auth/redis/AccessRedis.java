package run.freshr.domain.auth.redis;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import run.freshr.domain.auth.enumerations.Role;

@RedisHash("MEM_ACCESS_TOKEN")
@Getter
@Comment("접근 토큰 관리")
public class AccessRedis {

  @Id
  @Comment("일련 번호 - Access 토큰")
  private final String id;

  @Comment("계정 일련 번호")
  private final String signId;

  @Comment("권한")
  private final Role role;

  @TimeToLive
  @Comment("만료 시간")
  private final Long expiration;

  @Builder
  public AccessRedis(String id, String signId, Role role, Long expiration) {
    this.id = id;
    this.signId = signId;
    this.role = role;
    this.expiration = expiration;
  }

}
