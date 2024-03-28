package run.freshr.common.data;

import lombok.Builder;
import lombok.Data;

/**
 * Entity 데이터 모델
 *
 * @author FreshR
 * @apiNote Entity 데이터 모델
 * @since 2024. 3. 28. 오후 3:30:27
 */
@Data
@Builder
public class EntityData {

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
