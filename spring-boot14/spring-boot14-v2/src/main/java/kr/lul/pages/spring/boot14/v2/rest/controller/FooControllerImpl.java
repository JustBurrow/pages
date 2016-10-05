package kr.lul.pages.spring.boot14.v2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.lul.pages.spring.boot14.v2.business.dto.FooDto;
import kr.lul.pages.spring.boot14.v2.business.service.FooService;
import kr.lul.pages.spring.boot14.v2.rest.resp.FooListResp;
import kr.lul.pages.spring.boot14.v2.rest.resp.FooResp;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@RestController
class FooControllerImpl implements FooController {
  @Autowired
  private FooService fooService;

  /**
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public FooResp create() {
    FooDto foo = this.fooService.create();

    return new FooResp(foo);
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public FooListResp index() {
    List<FooDto> list = this.fooService.list(10);
    return new FooListResp(list);
  }

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public FooResp foo(@PathVariable("id") int id) {
    FooDto dto = this.fooService.read(id);
    return new FooResp(dto);
  }
}
