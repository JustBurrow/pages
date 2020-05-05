package kr.lul.blog.street.cat.study.common.repository;

import kr.lul.blog.street.cat.study.common.CommonTestConfiguration;
import kr.lul.blog.street.cat.study.common.data.Cat;
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
class CatRepositoryTest {
  protected static final Logger log = getLogger(CatRepositoryTest.class);
  @Autowired
  private CatRepository repository;

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
    Cat cat = new Cat(chipId, deviceId);
    log.info("GIVEN - cat={}", cat);

    // WHEN
    Cat saved = this.repository.save(cat);
    log.info("WHEN - saved={}", saved);

    // THEN
    assertThat(saved)
        .isNotNull()
        .extracting(Cat::getChipId, Cat::getDeviceId, Cat::isDeleted, Cat::getDeletedAt)
        .containsSequence(chipId, deviceId, false, null);
    assertThat(saved.getId())
        .isPositive();
    assertThat(saved.getCreatedAt())
        .isNotNull()
        .isAfter(before)
        .isEqualTo(saved.getUpdatedAt());
  }
}
