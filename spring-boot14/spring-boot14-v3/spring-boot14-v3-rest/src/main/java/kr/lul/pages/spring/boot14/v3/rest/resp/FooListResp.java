package kr.lul.pages.spring.boot14.v3.rest.resp;

import java.util.ArrayList;
import java.util.List;

import kr.lul.pages.spring.boot14.v3.business.dto.FooDto;
import lombok.Data;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@Data
public class FooListResp {
  private int          count;
  private List<FooDto> list;

  /**
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public FooListResp() {
    this.count = 0;
    this.list = new ArrayList<>();
  }

  /**
   * @author Just Burrow
   * @since 2016. 10. 4.
   * @param list
   */
  public FooListResp(List<FooDto> list) {
    this.count = list.size();
    this.list = new ArrayList<>(list);
  }
}
