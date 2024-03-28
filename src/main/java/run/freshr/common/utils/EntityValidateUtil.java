package run.freshr.common.utils;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import run.freshr.common.extensions.entity.EntityAuditLogicalExtension;
import run.freshr.common.extensions.entity.EntityAuditPhysicalExtension;
import run.freshr.common.extensions.entity.EntityLogicalExtension;
import run.freshr.common.extensions.entity.EntityPhysicalExtension;

/**
 * Entity 공통 검증 기능 정의
 *
 * @author FreshR
 * @apiNote Entity 공통 검증 기능 정의<br>
 *          모두 똑같은 검증이지만 parameter 속성이 같은 관계로 오버로딩 기능을 사용하지 못함
 * @since 2024. 3. 28. 오후 2:22:28
 */
@Slf4j
@Component
public class EntityValidateUtil {

  /**
   * 기본 검증
   *
   * @param <E>      Auditor 정보와 논리 삭제 정책을 가진 Entity
   * @param optional optional
   * @return boolean
   * @apiNote 삭제 여부와 사용 여부 검증
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:22:28
   */
  public static <E extends EntityAuditLogicalExtension<?>> boolean validateAuditorLogical(
      Optional<E> optional) {
    log.info("EntityValidateUtil.validateAuditorLogical");

    if (optional.isEmpty()) {
      return false;
    }

    E entity = optional.get();

    return !entity.getDeleteFlag() && entity.getUseFlag();
  }

  /**
   * 기본 검증
   *
   * @param <E>      논리 삭제 정책을 가진 Entity
   * @param optional optional
   * @return boolean
   * @apiNote 삭제 여부와 사용 여부 검증
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:22:28
   */
  public static <E extends EntityLogicalExtension> boolean validateLogical(Optional<E> optional) {
    log.info("EntityValidateUtil.validateLogical");

    if (optional.isEmpty()) {
      return false;
    }

    E entity = optional.get();

    return !entity.getDeleteFlag() && entity.getUseFlag();
  }

  /**
   * 기본 검증
   *
   * @param <E>      Auditor 정보와 물리 삭제 정책을 가진 Entity
   * @param optional optional
   * @return boolean
   * @apiNote 데이터가 있는지 검증
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:22:28
   */
  public static <E extends EntityAuditPhysicalExtension<?>> boolean validateAuditorPhysical(
      Optional<E> optional) {
    log.info("EntityValidateUtil.validateAuditorPhysical");

    return optional.isPresent();
  }

  /**
   * 기본 검증
   *
   * @param <E>      물리 삭제 정책을 가진 Entity
   * @param optional optional
   * @return boolean
   * @apiNote 데이터가 있는지 검증
   * @author FreshR
   * @since 2024. 3. 28. 오후 2:22:28
   */
  public static <E extends EntityPhysicalExtension> boolean validatePhysical(Optional<E> optional) {
    log.info("EntityValidateUtil.validateLogical");

    return optional.isPresent();
  }

}
