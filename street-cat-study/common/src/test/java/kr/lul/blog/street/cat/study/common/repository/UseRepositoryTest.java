package kr.lul.blog.street.cat.study.common.repository;

import kr.lul.blog.street.cat.study.common.CommonTestConfiguration;
import kr.lul.blog.street.cat.study.common.data.Use;
import kr.lul.blog.street.cat.study.common.data.UseType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CommonTestConfiguration.class)
class UseRepositoryTest {
  protected static final Logger log = getLogger(UseRepositoryTest.class);
  @Autowired
  private UseRepository repository;

  @Test
  void test_findAll() {
    assertThat(this.repository.findAll())
        .isNotNull();
  }

  @Test
  void test_save() {
    // GIVEN
    LocalDateTime before = LocalDateTime.now();
    log.info("GIVEN - before={}", before);

    UUID chipId = randomUUID();
    UUID deviceId = randomUUID();
    LocalDateTime measuredAt = LocalDateTime.now().minusDays(1L);
    Use use = new Use(chipId, deviceId, UseType.FOOD, 100, measuredAt);
    log.info("GIVEN - use={}", use);

    // WHEN
    Use saved = this.repository.save(use);
    log.info("WHEN - saved={}", saved);

    // THEN
    assertThat(saved)
        .isNotNull()
        .extracting(Use::getChipId, Use::getDeviceId, Use::getType, Use::getValue, Use::getMeasuredAt)
        .containsSequence(chipId, deviceId, UseType.FOOD, 100, measuredAt);
    assertThat(saved.getId())
        .isPositive();
    assertThat(saved.getCreatedAt())
        .isNotNull()
        .isAfter(before);
  }
}
