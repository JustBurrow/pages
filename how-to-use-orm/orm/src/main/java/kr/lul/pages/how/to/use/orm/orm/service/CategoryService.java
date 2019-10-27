package kr.lul.pages.how.to.use.orm.orm.service;

import kr.lul.pages.how.to.use.orm.orm.entity.Category;
import kr.lul.pages.how.to.use.orm.orm.repository.CategoryRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/27
 */
@Service
public class CategoryService {
  private static final Logger log = getLogger(CategoryService.class);

  @Autowired
  private CategoryRepository categoryRepository;

  public Category read(long id) {
    if (log.isTraceEnabled())
      log.trace("#read args : id={}", id);

    Category category = this.categoryRepository.findById(id).get();

    if (log.isTraceEnabled())
      log.trace("#read return : {}", category);
    return category;
  }
}
