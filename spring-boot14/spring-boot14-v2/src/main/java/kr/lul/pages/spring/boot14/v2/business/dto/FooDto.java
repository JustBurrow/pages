package kr.lul.pages.spring.boot14.v2.business.dto;

import java.time.Instant;

import lombok.Data;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@Data
public class FooDto {
  private int     id;
  private Instant create;

  /**
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public FooDto() {
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 3.
   * @param id
   * @param create
   */
  public FooDto(int id, Instant create) {
    this.id = id;
    this.create = create;
  }
}
