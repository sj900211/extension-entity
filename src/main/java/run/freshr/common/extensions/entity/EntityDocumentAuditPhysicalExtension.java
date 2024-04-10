package run.freshr.common.extensions.entity;

import static jakarta.persistence.FetchType.LAZY;
import static org.springframework.data.elasticsearch.annotations.DateFormat.date_hour_minute_second_millis;
import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Auditor 정보를 갖는 물리 삭제 MappedSuperclass
 *
 * @param <A> Auditor 데이터 유형
 * @author FreshR
 * @apiNote Audit 정보와 물리 삭제 정책을 가진 MappedSuperclass
 * @since 2024. 3. 27. 오후 1:46:56
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityDocumentAuditPhysicalExtension<A> {

  @Field(type = Date, format = date_hour_minute_second_millis)
  @Comment("등록 날짜 시간")
  protected LocalDateTime createAt;

  @Transient
  @CreatedBy
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "creator_id")
  @Comment("등록자 일련 번호")
  protected A creator;

  /**
   * 등록 처리
   *
   * @apiNote 등록 처리
   * @author FreshR
   * @since 2024. 4. 3. 오전 9:50:45
   */
  protected void create() {
    this.createAt = LocalDateTime.now();
  }

}
