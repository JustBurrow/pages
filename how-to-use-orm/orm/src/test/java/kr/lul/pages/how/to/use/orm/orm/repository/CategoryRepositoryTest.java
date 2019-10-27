package kr.lul.pages.how.to.use.orm.orm.repository;

import kr.lul.pages.how.to.use.orm.orm.ObjectRelationMappingModuleTestConfiguration;
import kr.lul.pages.how.to.use.orm.orm.entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ObjectRelationMappingModuleTestConfiguration.class)
@Transactional
public class CategoryRepositoryTest {
  private static final Logger log = getLogger(CategoryRepositoryTest.class);

  @Autowired
  private CategoryRepository repository;
  @Autowired
  private EntityManager entityManager;

  @Before
  public void setUp() throws Exception {
    assertThat(this.repository).isNotNull();
  }

  @Test
  public void test_save() throws Exception {
    // GIVEN
    final String name = random(10);
    final Category expected = new Category(name);
    log.info("GIVEN - expected={}", expected);

    // WHEN
    final Category actual = this.repository.save(expected);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .extracting(Category::getName)
        .isEqualTo(name);
    assertThat(actual.getId())
        .isPositive();
  }

  @Test
  public void test_fineOne() throws Exception {
    // GIVEN
    final Category expected = this.repository.saveAndFlush(new Category(random(10)));
    log.info("GIVEN - expected={}", expected);
    long id = expected.getId();
    String name = expected.getName();

    this.entityManager.clear();

    // WHEN
    Category actual = this.repository.findById(id).get();
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected)
        .isEqualTo(expected)
        .extracting(Category::getId, Category::getName)
        .containsSequence(id, name);
  }

  @Test
  public void test_findAll() throws Exception {
    // WHEN
    List<Category> list = this.repository.findAll();
    log.info("WHEN - list={}", list);

    // THEN
    assertThat(list)
        .isNotNull();
  }
}