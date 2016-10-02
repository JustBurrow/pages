package kr.lul.pages.spring.boot14.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Just Burrow
 * @since 2016. 10. 2.
 */
@Transactional
@Service
public class FooService {
  @Autowired
  private FooRepository fooRepository;

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 2.
   */
  public FooDto create() {
    Foo foo = new Foo();
    foo = this.fooRepository.save(foo);

    return new FooDto(foo.getId(), foo.getCreate());
  }

  public List<FooDto> list(int count) {
    PageRequest page = new PageRequest(0, count, Direction.DESC, "id");
    Page<Foo> foos = this.fooRepository.findAll(page);

    List<FooDto> list = foos.getContent().stream().map(f -> new FooDto(f.getId(), f.getCreate()))
        .collect(Collectors.toList());
    return list;
  }

  public FooDto read(int id) {
    Foo foo = this.fooRepository.findOne(id);
    return new FooDto(foo.getId(), foo.getCreate());
  }
}
