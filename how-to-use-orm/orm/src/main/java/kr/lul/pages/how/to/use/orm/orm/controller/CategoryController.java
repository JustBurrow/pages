package kr.lul.pages.how.to.use.orm.orm.controller;

import kr.lul.pages.how.to.use.orm.orm.entity.Category;
import kr.lul.pages.how.to.use.orm.orm.service.CategoryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/27
 */
@Controller
public class CategoryController {
  private static final Logger log = getLogger(CategoryController.class);

  @Autowired
  private CategoryService categoryService;

  @GetMapping("/category/{id:[1-9]\\d*}")
  public String read(@PathVariable("id") final long id, final Model model) {
    if (log.isTraceEnabled())
      log.trace("#read args : id={}, model={}", id, model);

    Category category = this.categoryService.read(id);
    model.addAttribute("category", category);

    if (log.isTraceEnabled())
      log.trace("#read result : model={}", model);
    return "page/category";
  }
}
