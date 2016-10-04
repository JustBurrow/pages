package kr.lul.pages.spring.boot14.v2.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.lul.pages.spring.boot14.v2.jpa.entity.FooEntity;
import kr.lul.pages.spring.boot14.v2.rest.Spring14Runner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Spring14Runner.class)
public class FooRepositoryTest {
  @Autowired
  private FooRepository fooRepository;

  @Before
  public void setUp() throws Exception {
    assertThat(this.fooRepository).isNotNull();
  }

  @Test
  public void testSave() throws Exception {
    // Given
    FooEntity expected = new FooEntity();
    Instant before = Instant.now();

    // When
    FooEntity actual = this.fooRepository.save(expected);

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate()).isGreaterThanOrEqualTo(before);
  }
}
