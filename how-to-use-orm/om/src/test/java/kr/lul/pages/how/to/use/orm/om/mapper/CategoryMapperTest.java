package kr.lul.pages.how.to.use.orm.om.mapper;

import kr.lul.pages.how.to.use.orm.om.ObjectMappingModuleTestConfiguration;
import kr.lul.pages.how.to.use.orm.om.model.Category;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ObjectMappingModuleTestConfiguration.class)
public class CategoryMapperTest {
  private static final Logger log = getLogger(CategoryMapperTest.class);

  @Autowired
  private CategoryMapper mapper;

  @BeforeEach
  void setUp() {
    assertThat(this.mapper)
        .isNotNull();
  }

  @Test
  public void test_create() throws Exception {
    // GIVEN
    final String name = random(5);
    final Category category = new Category(name);
    log.info("GIVEN - category={}", category);

    // WHEN
    int inserted = this.mapper.create(category);
    log.info("WHEN - inserted={}", inserted);

    // THEN
    log.info("THEN - category={}", category);
    assertThat(inserted)
        .isNotNull()
        .isEqualTo(1);
    assertThat(category.getId())
        .isPositive();
    assertThat(category.getName())
        .isEqualTo(name);
  }

  @Test
  public void test_read() throws Exception {
    // GIVEN
    final Category expected = new Category(random(5));
    this.mapper.create(expected);
    log.info("GIVEN - expected={}", expected);
    final long id = expected.getId();
    final String name = expected.getName();

    // WHEN
    final Category actual = this.mapper.read(id);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected)
        .extracting(Category::getId, Category::getName)
        .containsSequence(id, name);
  }

  @Test
  public void test_list() throws Exception {
    // WHEN
    List<Category> list = this.mapper.list();
    log.info("WHEN - list={}", list);

    // THEN
    assertThat(list)
        .isNotNull();
  }
}
