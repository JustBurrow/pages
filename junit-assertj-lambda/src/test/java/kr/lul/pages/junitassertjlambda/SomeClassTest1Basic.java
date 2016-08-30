package kr.lul.pages.junitassertjlambda;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import kr.lul.pages.junitassertjlambda.SomeClass;

/**
 * 기본 테스트 코드.
 */
public class SomeClassTest1Basic {
  private SomeClass sc;

  @Before
  public void setUp() throws Exception {
    this.sc = new SomeClass();
  }

  @Test
  public void testSomeMethod() throws Exception {
    this.sc.someMethod("123");
  }

  /**
   * 단순히 {@link NullPointerException}이 발생했다는 사실만 알 수 있을 뿐, 왜 예외가 발생했는지 알 수 없다.
   * 이 경우, {@link SomeClass}의 <code>hidden</code> 필드가 <code>null</code>일 경우에도 NPE가 발생할 수 있다.
   */
  @Test(expected = NullPointerException.class)
  public void testSomeMethodWithNull() {
    this.sc.someMethod(null);
  }

  /**
   * 예외를 대하는 바른 자세.
   */
  @Test
  public void testSomeMethodWithEmpty() throws Exception {
    try {
      this.sc.someMethod("");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("text length : 0", e.getMessage());
    }
  }

  /**
   * 예외를 대하는 바른 자세..?
   */
  @Test
  public void testSomeMethodWithLength1() throws Exception {
    try {
      this.sc.someMethod("1");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("text length : 1", e.getMessage());
    }
  }

  /**
   * <p>
   * 벌써 3번째 반복이다.
   * </p>
   * <p>
   * {@link SomeClass}는 예외가 발생하는 범위가 0, 1, 2의 3가지 경우의 수로 전체 테스트 코드 작성이 가능하다.
   * 하지만 10 ~ 30 정도의 테스트 케이스를 전부 작성하기엔 지저분하고 하지 않기엔 찝찝한 경우를 만날 수도 있다.
   * </p>
   * <p>
   * 예외에 대한 테스트를 좀 더 세분화했다.
   * </p>
   */
  @Test
  public void testSomeMethodWithLength2() throws Exception {
    try {
      this.sc.someMethod("12");
      fail();
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), allOf(startsWith("text length"), endsWith("" + "12".length())));
    }
  }
}
