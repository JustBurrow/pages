package kr.lul.pages.junitassertjlambda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Before;
import org.junit.Test;

import kr.lul.pages.junitassertjlambda.SomeClass;

/**
 * AssertJ 도입.
 * JUnit을 테스트케이스를 실행하는 실행환경으로 사용하고, 실재 테스트(assertion)는 AssertJ에 위임한다.
 */
public class SomeClassTest2AssertJ {
  private SomeClass sc;

  @Before
  public void setUp() throws Exception {
    this.sc = new SomeClass();
  }

  /**
   * AssertJ를 도입해 테스트를 만들었다.
   */
  @Test
  public void testSomeMethod() throws Exception {
    assertThat(this.sc.someMethod("123")).isEqualTo(true);
  }

  /**
   * AssertJ는 예외도 다각도로 테스트할 수 있도록 도와준다.
   * 예외를 테스트하기 위해 {@link ThrowingCallable}로 메서드 실행을 캡슐화 한다.
   */
  @Test
  public void testSomeMethodWithNull() {
    assertThatThrownBy(new ThrowingCallable() {
      @Override
      public void call() throws Throwable {
        SomeClassTest2AssertJ.this.sc.someMethod(null);
      }
    }).isInstanceOf(NullPointerException.class)
        .hasMessage("text");
  }

  /**
   * 람다를 사용하면 코드가 깔끔하게 정리된다.
   */
  @Test
  public void testSomeMethodWithShortText() throws Exception {
    // 이랬던 코드가
    assertThatThrownBy(new ThrowingCallable() {
      @Override
      public void call() throws Throwable {
        SomeClassTest2AssertJ.this.sc.someMethod("");
      }
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "".length());

    // 이렇게 정리된다.
    // 2개의 테스트 케이스를 실행하지만, 줄 수는 익명 클래스를 만든 경우와 비슷하다.
    assertThatThrownBy(() -> this.sc.someMethod("1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "1".length());
    assertThatThrownBy(() -> this.sc.someMethod("12"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("text length")
        .hasMessageEndingWith("" + "12".length());
  }
}
