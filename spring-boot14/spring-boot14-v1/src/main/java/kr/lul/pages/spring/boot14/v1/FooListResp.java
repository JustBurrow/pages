package kr.lul.pages.spring.boot14.v1;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@Data
public class FooListResp {
  private int          count;
  private List<FooDto> list;

  /**
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  public FooListResp() {
    this.count = 0;
    this.list = new ArrayList<>();
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 1.
   * @param list
   */
  public FooListResp(List<FooDto> list) {
    this.count = list.size();
    this.list = new ArrayList<>(list);
  }
}
