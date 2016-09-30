package kr.lul.pages.spring.boot14.v1;

import java.time.Instant;

import lombok.Data;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@Data
public class FooResp {
  private int     id;
  private Instant create;

  public FooResp() {
  }

  public FooResp(int id, Instant create) {
    this.id = id;
    this.create = create;
  }

  public FooResp(FooDto dto) {
    this.id = dto.getId();
    this.create = dto.getCreate();
  }
}
