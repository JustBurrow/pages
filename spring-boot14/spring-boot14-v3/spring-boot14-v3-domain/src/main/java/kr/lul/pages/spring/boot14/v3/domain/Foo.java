package kr.lul.pages.spring.boot14.v3.domain;

import java.time.Instant;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
public interface Foo {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public int getId();

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public Instant getCreate();
}
