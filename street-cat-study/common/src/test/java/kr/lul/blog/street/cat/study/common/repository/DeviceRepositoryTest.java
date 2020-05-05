package kr.lul.blog.street.cat.study.common.repository;

import kr.lul.blog.street.cat.study.common.CommonTestConfiguration;
import kr.lul.blog.street.cat.study.common.data.Device;
import kr.lul.blog.street.cat.study.common.data.DeviceType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
class DeviceRepositoryTest {
  protected static final Logger log = getLogger(DeviceRepositoryTest.class);

  @Autowired
  private DeviceRepository repository;

  @Test
  void test_findAll() {
    assertThat(this.repository.findAll())
        .isNotNull();
  }

  @Test
  void test_save() {
    // GIVEN
    UUID deviceId = randomUUID();
    Device device = new Device(deviceId, DeviceType.FOOD);
    log.info("GIVEN - device={}", device);

    // WHEN
    Device saved = this.repository.save(device);
    log.info("WHEN - saved={}", saved);

    // THEN
    assertThat(saved)
        .isNotNull()
        .extracting(Device::getDeviceId, Device::getType)
        .containsSequence(deviceId, DeviceType.FOOD);
    assertThat(saved.getId())
        .isPositive();
  }
}
