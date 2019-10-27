package kr.lul.pages.how.to.use.orm.om.controller;

import kr.lul.pages.how.to.use.orm.om.model.Category;
import kr.lul.pages.how.to.use.orm.om.model.Product;
import kr.lul.pages.how.to.use.orm.om.service.CategoryService;
import kr.lul.pages.how.to.use.orm.om.service.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/10/23
 */
@Controller
public class CategoryController {
  private static final Logger log = getLogger(CategoryController.class);

  @Autowired
  private CategoryService categoryService;
  @Autowired
  private ProductService productService;

  @GetMapping("/category/{id:[1-9]\\d*}")
  public String read(@PathVariable("id") final long id, final Model model) {
    if (log.isTraceEnabled())
      log.trace("#read args : id={}, model={}", id, model);

    Category category = this.categoryService.read(id);
    if (null == category) {
      String msg = format("category(id:%d) does not exist.", id);
      log.warn(msg);
      throw new RuntimeException(msg);
    }
    List<Product> products = this.productService.products(id);

    model.addAttribute("category", category);
    model.addAttribute("products", products);

    if (log.isTraceEnabled())
      log.trace("#read result : model={}", model);
    return "page/category";
  }
}
