package kr.lul.pages.spring.boot14.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@RestController
@RequestMapping("/foos")
public class FooController {
  @Autowired
  private FooService fooService;

  /**
   * @author Just Burrow
   * @since 2016. 10. 2.
   */
  @GetMapping("/create")
  public FooResp create() {
    FooDto foo = this.fooService.create();

    return new FooResp(foo);
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  @GetMapping
  public FooListResp index() {
    List<FooDto> list = this.fooService.list(10);
    return new FooListResp(list);
  }

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  @GetMapping("/{id}")
  public FooResp foo(@PathVariable("id") int id) {
    FooDto dto = this.fooService.read(id);
    return new FooResp(dto);
  }
}
