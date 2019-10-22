package kr.lul.pages.how.to.use.orm.om.service;

import kr.lul.pages.how.to.use.orm.om.ObjectMappingModuleTestConfiguration;
import kr.lul.pages.how.to.use.orm.om.mapper.ProductMapper;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ObjectMappingModuleTestConfiguration.class)
@Transactional
public class ProductServiceTest {
  private static final Logger log = getLogger(ProductServiceTest.class);

  @Autowired
  private ProductService service;
  @Autowired
  private ProductMapper productMapper;

  @BeforeEach
  void setUp() {
    assertThat(this.service).isNotNull();
  }

  @Test
  public void test_products_contains_1() throws Exception {
    // WHEN
    List<Product> products = this.service.products(1L);
    log.info("WHEN - products={}", products);

    // THEN
    Product product = this.productMapper.read(1L);
    log.info("THEN - product={}", product);
    assertThat(products)
        .hasSize(1)
        .doesNotContainNull()
        .containsOnly(product);
  }
}
