package kr.lul.pages.spring.boot14.v3.business.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.lul.pages.spring.boot14.v3.TestConfig;
import kr.lul.pages.spring.boot14.v3.business.dto.FooDto;

/**
 * @author Just Burrow
 * @since 2016. 10. 4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class FooServiceTest {
  @Autowired
  private FooService fooService;

  private Instant    before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.fooService).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testCreate() throws Exception {
    // When
    FooDto actual = this.fooService.create();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate()).isGreaterThanOrEqualTo(this.before);
  }

  @Test
  public void testList() throws Exception {
    // Given
    int count = this.fooService.list(Integer.MAX_VALUE).size();
    FooDto created = this.fooService.create();

    // When
    List<FooDto> list = this.fooService.list(Integer.MAX_VALUE);

    // Then
    assertThat(list).isNotNull()
        .size().isEqualTo(count + 1);
    assertThat(list.get(0)).extracting(FooDto::getId, FooDto::getCreate)
        .containsExactly(created.getId(), created.getCreate());
  }

  @Test
  public void testRead() throws Exception {
    // Given
    FooDto expected = this.fooService.create();

    // When
    FooDto actual = this.fooService.read(expected.getId());

    // Then
    assertThat(actual).isNotNull()
        .isEqualTo(expected)
        .isNotSameAs(expected);
  }
}
