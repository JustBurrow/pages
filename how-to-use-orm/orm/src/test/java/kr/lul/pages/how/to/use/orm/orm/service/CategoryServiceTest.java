package kr.lul.pages.how.to.use.orm.orm.service;

import kr.lul.pages.how.to.use.orm.orm.ObjectRelationMappingModuleTestConfiguration;
import kr.lul.pages.how.to.use.orm.orm.entity.Category;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ObjectRelationMappingModuleTestConfiguration.class)
@Transactional
public class CategoryServiceTest {
  private static final Logger log = getLogger(CategoryServiceTest.class);

  @Autowired
  private CategoryService service;

  @BeforeEach
  void setUp() {
    assertThat(this.service).isNotNull();
  }

  @Test
  public void test_read_with_1() throws Exception {
    // WHEN
    Category category = this.service.read(1L);
    log.info("WHEN - category={}", category);

    // THEN
    assertThat(category)
        .isNotNull()
        .extracting(Category::getId)
        .isEqualTo(1L);
  }
}
