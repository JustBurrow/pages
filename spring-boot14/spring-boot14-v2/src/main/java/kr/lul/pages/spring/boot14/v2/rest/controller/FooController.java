package kr.lul.pages.spring.boot14.v2.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.lul.pages.spring.boot14.v2.rest.resp.FooListResp;
import kr.lul.pages.spring.boot14.v2.rest.resp.FooResp;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@RequestMapping("/foos")
public interface FooController {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @GetMapping("/create")
  public FooResp create();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @GetMapping
  public FooListResp index();

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @GetMapping("/{id}")
  public FooResp foo(@PathVariable("id") int id);
}
