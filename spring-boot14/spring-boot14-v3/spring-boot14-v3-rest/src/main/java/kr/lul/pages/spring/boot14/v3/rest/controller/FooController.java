package kr.lul.pages.spring.boot14.v3.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.lul.pages.spring.boot14.v3.rest.resp.FooListResp;
import kr.lul.pages.spring.boot14.v3.rest.resp.FooResp;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@RequestMapping("/foos")
public interface FooController {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @GetMapping("/create")
  public FooResp create();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @GetMapping
  public FooListResp index();

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @GetMapping("/{id}")
  public FooResp foo(@PathVariable("id") int id);
}
