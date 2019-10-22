package kr.lul.pages.how.to.use.orm.om.service;

import kr.lul.pages.how.to.use.orm.om.mapper.ProductMapper;
import kr.lul.pages.how.to.use.orm.om.model.Product;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Service
public class ProductService {
  private static final Logger log = getLogger(ProductService.class);

  @Autowired
  private ProductMapper productMapper;

  public List<Product> products(long categoryId) {
    if (log.isTraceEnabled()) log.trace("args : categoryId={}", categoryId);

    List<Product> products = this.productMapper.listByCategory(categoryId);

    if (log.isTraceEnabled()) log.trace("return : {}", products);
    return products;
  }
}
