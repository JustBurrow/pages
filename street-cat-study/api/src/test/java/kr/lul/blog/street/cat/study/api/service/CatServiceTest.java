package kr.lul.blog.street.cat.study.api.service;

import kr.lul.blog.street.cat.study.api.ApiTestConfiguration;
import kr.lul.blog.street.cat.study.common.data.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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
@SpringBootTest(classes = ApiTestConfiguration.class)
@Transactional
class CatServiceTest {
  protected static final Logger log = getLogger(CatServiceTest.class);

  @Autowired
  private CatService service;

  private LocalDateTime before;

  @BeforeEach
  void setUp() {
    this.before = LocalDateTime.now();
    log.info("SETUP - before={}", this.before);
  }

  @Test
  void test_add() {
    // GIVEN
    UUID chipId = randomUUID();
    UUID deviceId = randomUUID();
    log.info("GIVEN - chipId={}, deviceId={}", chipId, deviceId);

    // WHEN
    Cat cat = this.service.add(chipId, deviceId);
    log.info("WHEN - cat={}", cat);

    // THEN
    assertThat(cat)
        .isNotNull()
        .extracting(Cat::getChipId, Cat::getDeviceId, Cat::isDeleted, Cat::getDeletedAt)
        .containsSequence(chipId, deviceId, false, null);
    assertThat(cat.getId())
        .isPositive();
    assertThat(cat.getCreatedAt())
        .isNotNull()
        .isAfter(this.before)
        .isEqualTo(cat.getUpdatedAt());
  }

  @Test
  void test_add_twice() {
    // GIVEN
    UUID chipId = randomUUID();
    UUID deviceId = randomUUID();
    log.info("GIVEN - chipId={}, deviceId={}", chipId, deviceId);
    Cat cat1 = this.service.add(chipId, deviceId);
    log.info("GIVEN - cat1={}", cat1);

    // WHEN
    Cat cat2 = this.service.add(chipId, deviceId);
    log.info("WHEN - cat2={}", cat2);

    // THEN
    assertThat(cat2)
        .isNotNull()
        .extracting(Cat::getId, Cat::getChipId, Cat::getDeviceId,
            Cat::getCreatedAt, Cat::getUpdatedAt, Cat::isDeleted, Cat::getDeletedAt)
        .containsSequence(cat1.getId(), chipId, deviceId,
            cat1.getCreatedAt(), cat1.getUpdatedAt(), false, null);

  }
}
