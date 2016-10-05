package kr.lul.pages.spring.boot14.v3.business.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.lul.pages.spring.boot14.v3.business.dto.FooDto;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@Transactional
public interface FooService {
  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public FooDto create();

  /**
   * @param count
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public List<FooDto> list(int count);

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  public FooDto read(int id);
}
