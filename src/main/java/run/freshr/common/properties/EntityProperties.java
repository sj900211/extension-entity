package run.freshr.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Entity 속성 정의
 *
 * @author FreshR
 * @apiNote Entity 속성을 정의해서 application.properties 또는 application.yml 에서 사용할 수 있도록 설정
 * @since 2024. 3. 28. 오후 3:31:51
 */
@Data
@ConfigurationProperties("freshr.entity")
public class EntityProperties {

  /**
   * RSA TTL
   *
   * @apiNote RSA TTL
   * @since 2024. 3. 28. 오후 3:31:51
   */
  private Long rsaTtl;
  /**
   * Access Token TTL
   *
   * @apiNote Access Token TTL
   * @since 2024. 3. 28. 오후 3:31:51
   */
  private Long accessTtl;
  /**
   * Refresh Token TTL
   *
   * @apiNote Refresh Token TTL
   * @since 2024. 3. 28. 오후 3:31:51
   */
  private Long refreshTtl;
  /**
   * Access Token 만료 시간
   *
   * @apiNote Access Token 만료 시간
   * @since 2024. 3. 28. 오후 3:31:51
   */
  private Long accessExpiration;

}
