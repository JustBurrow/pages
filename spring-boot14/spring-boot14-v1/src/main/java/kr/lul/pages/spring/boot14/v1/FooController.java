package kr.lul.pages.spring.boot14.v1;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Just Burrow
 * @since 2016. 10. 1.
 */
@RestController
@RequestMapping("/foos")
public class FooController {
  private AtomicInteger        id;
  private Random               rand;
  private Map<Integer, FooDto> fooBox;

  /**
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  @PostConstruct
  private void postConstruct() {
    this.id = new AtomicInteger(1);
    this.rand = new Random();
    this.fooBox = new LinkedHashMap<>();
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  private FooDto randomDto() {
    FooDto dto = new FooDto(this.id.getAndIncrement(), Instant.now());
    synchronized (this.fooBox) {
      this.fooBox.put(dto.getId(), dto);
    }
    return dto;
  }

  /**
   * @return
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  @GetMapping
  public FooListResp index() {
    int cnt = this.rand.nextInt(10);
    List<FooDto> list = IntStream.range(0, cnt).mapToObj(i -> this.randomDto()).collect(Collectors.toList());
    return new FooListResp(list);
  }

  /**
   * @param id
   * @return
   * @author Just Burrow
   * @since 2016. 10. 1.
   */
  @GetMapping("/{id}")
  public FooResp foo(@PathVariable("id") int id) {
    FooDto dto = this.randomDto();
    return new FooResp(dto);
  }
}
