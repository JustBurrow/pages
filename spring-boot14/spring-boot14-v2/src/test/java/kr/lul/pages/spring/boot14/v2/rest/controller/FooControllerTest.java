package kr.lul.pages.spring.boot14.v2.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.lul.pages.spring.boot14.v2.rest.Spring14Runner;
import kr.lul.pages.spring.boot14.v2.rest.resp.FooListResp;
import kr.lul.pages.spring.boot14.v2.rest.resp.FooResp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Spring14Runner.class)
public class FooControllerTest {
  @Autowired
  private FooController fooController;

  private Instant       before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.fooController).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testCreate() throws Exception {
    // When
    FooResp actual = this.fooController.create();

    // Then
    assertThat(actual).isNotNull();
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate()).isGreaterThanOrEqualTo(this.before);
  }

  @Test
  public void testList() throws Exception {
    // When
    FooListResp resp = this.fooController.index();

    // Then
    assertThat(resp).isNotNull()
        .extracting(FooListResp::getCount).containsExactly(resp.getList().size());
  }

  @Test
  public void testIndex() throws Exception {
    // When
    FooListResp resp = this.fooController.index();

    // then
    assertThat(resp).isNotNull();
    assertThat(resp.getList()).isNotNull()
        .size().isEqualTo(resp.getCount());
  }
}
