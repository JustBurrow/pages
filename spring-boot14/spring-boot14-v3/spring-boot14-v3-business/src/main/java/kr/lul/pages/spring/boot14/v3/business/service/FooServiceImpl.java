package kr.lul.pages.spring.boot14.v3.business.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kr.lul.pages.spring.boot14.v3.business.dto.FooDto;
import kr.lul.pages.spring.boot14.v3.domain.Foo;
import kr.lul.pages.spring.boot14.v3.jpa.entity.FooEntity;
import kr.lul.pages.spring.boot14.v3.jpa.repository.FooRepository;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@Service
class FooServiceImpl implements FooService {
  @Autowired
  private FooRepository fooRepository;

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @Override
  public FooDto create() {
    FooEntity foo = new FooEntity();
    foo = this.fooRepository.save(foo);

    return new FooDto(foo.getId(), foo.getCreate());
  }

  /**
   * @param count
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @Override
  public List<FooDto> list(int count) {
    PageRequest page = new PageRequest(0, count, Direction.DESC, "id");
    Page<FooEntity> foos = this.fooRepository.findAll(page);

    List<FooDto> list = foos.getContent().stream().map(f -> new FooDto(f.getId(), f.getCreate()))
        .collect(Collectors.toList());
    return list;
  }

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 4.
   */
  @Override
  public FooDto read(int id) {
    Foo foo = this.fooRepository.findOne(id);
    return new FooDto(foo.getId(), foo.getCreate());
  }
}
