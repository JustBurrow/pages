package kr.lul.pages.spring.boot14.v2.business.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.lul.pages.spring.boot14.v2.business.dto.FooDto;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@Transactional
public interface FooService {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public FooDto create();

  /**
   * @param count
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public List<FooDto> list(int count);

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  public FooDto read(int id);
}
