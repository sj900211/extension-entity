package run.freshr.common.configurations;

import static java.util.Optional.ofNullable;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import run.freshr.common.data.EntityData;
import run.freshr.common.properties.EntityProperties;

/**
 * Entity 설정
 *
 * @author FreshR
 * @apiNote application.properties 와 application.yml 에서 설정한 값과<br>
 *          기본 설정 값으로 Entity 데이터 객체 설정
 * @since 2024. 3. 28. 오후 3:30:27
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(EntityProperties.class)
public class EntityAutoConfiguration {

  /**
   * Entity 데이터 객체 설정
   *
   * @param properties application.properties 와 application.yml 에서 설정한 값
   * @return Logstash 데이터 객체
   * @apiNote application.properties 와 application.yml 에서 설정한 값과<br>
   *          기본 설정 값으로 Entity 데이터 객체 설정
   * @author FreshR
   * @since 2024. 3. 28. 오후 3:30:27
   */
  @Bean
  @ConditionalOnMissingBean
  public EntityData logstashData(EntityProperties properties) {
    return EntityData
        .builder()
        .rsaTtl(ofNullable(properties.getRsaTtl()).orElse(5L * 60L))
        .accessTtl(ofNullable(properties.getRsaTtl()).orElse(6L * 30L * 24L * 60L * 60L))
        .refreshTtl(ofNullable(properties.getRefreshTtl()).orElse(6L * 30L * 24L * 60L * 60L))
        .accessExpiration(ofNullable(properties.getAccessExpiration()).orElse(15L * 60L))
        .build();
  }

}
