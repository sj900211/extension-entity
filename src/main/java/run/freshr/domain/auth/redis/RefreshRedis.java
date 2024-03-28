package run.freshr.domain.auth.redis;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("MEM_REFRESH_TOKEN")
@Getter
@Comment("갱신 토큰 관리")
public class RefreshRedis {

  @Id
  @Comment("일련 번호 - Refresh 토큰")
  private final String id;

  @Reference
  @Comment("Access 토큰")
  private AccessRedis access;

  @Comment("마지막 갱신 날짜 시간")
  private LocalDateTime updateAt;

  @TimeToLive
  @Comment("만료 시간")
  private Long expiration;

  @Builder
  public RefreshRedis(String id, AccessRedis access, Long expiration) {
    this.id = id;
    this.access = access;
    this.expiration = expiration;
    this.updateAt = LocalDateTime.now();
  }

  public void updateRedis(AccessRedis access, Long expiration) {
    this.access = access;
    this.expiration = expiration;
    this.updateAt = LocalDateTime.now();
  }

}
