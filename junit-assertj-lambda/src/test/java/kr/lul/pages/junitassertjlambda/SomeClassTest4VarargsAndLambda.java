package kr.lul.pages.junitassertjlambda;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import kr.lul.pages.junitassertjlambda.SomeClass;

/**
 * AssertJ 도입.
 * JUnit을 테스트케이스를 실행하는 실행환경으로 사용하고, 실재 테스트(assertion)는 AssertJ에 위임한다.
 */
public class SomeClassTest4VarargsAndLambda {
  private SomeClass sc = new SomeClass();

  /**
   * 내가 람다다.
   */
  public static interface AssertLambda {
    public void exec(ThrowingCallable callable);
  }

  /**
   * 내가 헬퍼다.
   * 헬퍼의 기능이 람다에 메서드 실행을 하나씩 넘겨주는 것으로 단순해졌다.
   * 그와 동시에 어떤 테스트를 해야 할 것인지 알 필요가 없어졌기 때문에, 범용성이 좋아졌다.
   * 범용성이 좋아졌기 때문에, 어디서든 접근, 사용할 수 있도록 접근 제한자를 <code>public static</code>으로 변경했다.
   */
  public static void assertHelper(AssertLambda assertion, ThrowingCallable... callables) {
    for (ThrowingCallable callable : callables) {
      assertion.exec(callable);
    }
  }

  /**
   * <p>
   * 실재 테스트 내용을 별도의 메서드에 작성한 {@link SomeClassTest3Varargs}에 비교하면,
   * 테스트(assertion) 내용을 테스트 케이스({@link Test})에 작성하는 방식으로 바뀌었다.
   * </p>
   * <p>
   * 테스트 케이스의 주석, 메서드 이름, 테스트 내용, 테스트 대상(메서드 실행)이 짧은 코드로 한곳에 모였다.
   * 이 정도면 상당히 가독성 좋은 코드라고 생각한다.
   * </p>
   */
  @Test
  public void testSomeMethodWithShortTextViaHelper() throws Exception {
    SomeClassTest4VarargsAndLambda.assertHelper(
        (callable) -> assertThatThrownBy(callable)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("text length : [0-2]"),
        () -> this.sc.someMethod(""),
        () -> this.sc.someMethod("1"),
        () -> this.sc.someMethod("12"));
  }
}
