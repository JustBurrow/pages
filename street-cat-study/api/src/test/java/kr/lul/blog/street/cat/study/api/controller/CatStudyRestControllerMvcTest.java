package kr.lul.blog.street.cat.study.api.controller;

import kr.lul.blog.street.cat.study.api.ApiTestConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static java.lang.String.format;
import static java.util.UUID.randomUUID;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CatStudyRestController.class)
@ContextConfiguration(classes = ApiTestConfiguration.class)
class CatStudyRestControllerMvcTest {
  protected static final Logger log = getLogger(CatStudyRestControllerMvcTest.class);

  @Autowired
  private MockMvc mock;

  //@Test
  void test_add() throws Exception {
    // GIVEN
    UUID chipId = randomUUID();
    UUID deviceId = randomUUID();
    log.info("GIVEN - chipId={}, deviceId={}", chipId, deviceId);

    // WHEN
    this.mock.perform(post("/api/add")
                          .contentType(MediaType.APPLICATION_JSON)
                          .content(format("{\"chipId\":\"%s\",\"deviceId\":\"%s\"}", chipId, deviceId)))

        // THEN
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(greaterThan(0L)))
        .andExpect(jsonPath("$.createdAt").value(notNullValue()))
        .andDo(print());
  }
}