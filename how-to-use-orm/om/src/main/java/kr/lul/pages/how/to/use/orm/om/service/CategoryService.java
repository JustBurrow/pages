package kr.lul.pages.how.to.use.orm.om.service;

import kr.lul.pages.how.to.use.orm.om.dao.CategoryDao;
import kr.lul.pages.how.to.use.orm.om.model.Category;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/22
 */
@Service
public class CategoryService {
  private static final Logger log = getLogger(CategoryService.class);

  @Autowired
  private CategoryDao categoryDao;

  public Category read(long id) {
    if (log.isTraceEnabled()) log.trace("#read args : id={}", id);

    Category category = this.categoryDao.read(id);

    if (log.isTraceEnabled()) log.trace("#read return : {}", category);
    return category;
  }
}
