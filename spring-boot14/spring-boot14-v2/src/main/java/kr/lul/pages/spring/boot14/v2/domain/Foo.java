package kr.lul.pages.spring.boot14.v2.domain;

import java.time.Instant;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
public interface Foo {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public int getId();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public Instant getCreate();
}
