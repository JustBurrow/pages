package kr.lul.pages.junitassertjlambda;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Before;
import org.junit.Test;

/**
 * AssertJ 도입.
 * JUnit을 테스트케이스를 실행하는 실행환경으로 사용하고, 실재 테스트(assertion)는 AssertJ에 위임한다.
 */
public class SomeClassTest3Varargs {
  private SomeClass sc;

  @Before
  public void setUp() throws Exception {
    this.sc = new SomeClass();
  }

  /**
   * 이 테스트 코드를 좀 더 깔끔하게 만들어보자.
   */
  @Test
  public void testSomeMethodWithShortText() throws Exception {
    assertThatThrownBy(() -> this.sc.someMethod(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "".length());
    assertThatThrownBy(() -> this.sc.someMethod("1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "1".length());
    assertThatThrownBy(() -> this.sc.someMethod("12"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "12".length());
  }

  /**
   * 가변 변수로 메서드 실행을 객체화한 {@link ThrowingCallable} 목록을 받고, 메서드 호출을 실행한 후 발생한 예외를 검증한다.
   */
  private void assertHelper(ThrowingCallable... callables) {
    for (ThrowingCallable callable : callables) {
      assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class)
          .hasMessageMatching("text length : [0-2]");
    }
  }

  /**
   * 테스트 헬퍼({@link #assertHelper(ThrowingCallable...)})를 호출해 단위 테스트를 실행하자.
   */
  @Test
  public void testSomeMethodWithShortTextViaHelper() throws Exception {
    this.assertHelper(
        () -> this.sc.someMethod(""),
        () -> this.sc.someMethod("1"),
        () -> this.sc.someMethod("12"));
  }
}
