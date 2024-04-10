package run.freshr.domain.auth.redis;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("MEM_RSA_PAIR")
@Getter
@Comment("RSA 키 관리")
public class RsaPair {

  @Id
  @Comment("일련 번호 - 공개 키")
  private final String publicKey;

  @Comment("비공개 키")
  private final String privateKey;

  @Comment("등록 날짜 시간")
  private final LocalDateTime createAt;

  @TimeToLive
  @Comment("만료 시간")
  private final Long expiration;

  @Builder
  public RsaPair(String publicKey, String privateKey, LocalDateTime createAt, Long expiration) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    this.createAt = createAt;
    this.expiration = expiration;
  }

}
