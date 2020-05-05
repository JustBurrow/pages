package kr.lul.blog.street.cat.study.api.controller;

import kr.lul.blog.street.cat.study.api.ApiTestConfiguration;
import kr.lul.blog.street.cat.study.api.controller.request.AddRequest;
import kr.lul.blog.street.cat.study.api.controller.response.AddResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApiTestConfiguration.class)
public class CatStudyRestControllerTest {
  protected static final Logger log = getLogger(CatStudyRestControllerTest.class);

  @Autowired
  private CatStudyRestController controller;

  private LocalDateTime before;

  @BeforeEach
  void setUp() {
    this.before = LocalDateTime.now();
    log.info("SETUP - before={}", this.before);
  }

  @Test
  void test_add() {
    // GIVEN
    AddRequest request = new AddRequest(randomUUID(), randomUUID());
    log.info("GIVEN - request={}", request);

    // WHEN
    AddResponse response = this.controller.add(request);
    log.info("WHEN - response={}", response);

    // THEN
    assertThat(response)
        .isNotNull()
        .extracting(AddResponse::getChipId)
        .isEqualTo(request.getChipId());
    assertThat(response.getCreatedAt())
        .isNotNull()
        .isAfter(this.before);
  }
}
