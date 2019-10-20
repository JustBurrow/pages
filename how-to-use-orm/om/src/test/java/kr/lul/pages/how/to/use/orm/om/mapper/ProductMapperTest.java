package kr.lul.pages.how.to.use.orm.om.mapper;

import kr.lul.pages.how.to.use.orm.om.ObjectMappingModuleTestConfiguration;
import kr.lul.pages.how.to.use.orm.om.model.Product;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class ProductMapperTest {
  private static final Logger log = getLogger(ProductMapperTest.class);

  @Autowired
  private ProductMapper mapper;

  @BeforeEach
  public void setUp() {
    assertThat(this.mapper).isNotNull();
  }

  @Test
  public void test_create() throws Exception {
    // GIVEN
    final String name = "상품 : " + random(10);
    final Product product = new Product(name);
    log.info("GIVEN - product={}", product);

    // WHEN
    final int inserted = this.mapper.create(product);
    log.info("WHEN - inserted={}", inserted);

    // THEN
    assertThat(inserted)
        .isEqualTo(1);
    assertThat(product.getId())
        .isPositive();
    assertThat(product.getName())
        .isEqualTo(name);
  }

  @Test
  public void test_read() throws Exception {
    // GIVEN
    final Product expected = new Product(random(10));
    this.mapper.create(expected);
    final long id = expected.getId();
    final String name = expected.getName();

    // WHEN
    final Product actual = this.mapper.read(id);
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isNotSameAs(expected)
        .extracting(Product::getId, Product::getName)
        .containsSequence(id, name);
  }

  @Test
  public void test_list() throws Exception {
    // WHEN
    List<Product> list = this.mapper.list();
    log.info("WHEN - list={}", list);

    // THEN
    assertThat(list)
        .isNotNull();
  }
}
