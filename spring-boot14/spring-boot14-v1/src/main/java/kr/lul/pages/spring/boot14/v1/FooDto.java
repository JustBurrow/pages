package kr.lul.pages.spring.boot14.v1;

import java.time.Instant;

import lombok.Data;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@Data
public class FooDto {
  private int     id;
  private Instant create;

  public FooDto() {
  }

  public FooDto(int id, Instant create) {
    this.id = id;
    this.create = create;
  }
}
