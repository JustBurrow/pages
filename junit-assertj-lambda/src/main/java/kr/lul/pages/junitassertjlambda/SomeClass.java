package kr.lul.pages.junitassertjlambda;

import java.util.Random;

/**
 * 무쓸모 클래스.
 */
public class SomeClass {
  /**
   * 상황을 복잡하게 만들 수 있는 녀석.
   */
  private String hidden;

  public SomeClass() {
    this.hidden = "";
  }

  /**
   * 상황을 복잡하게 만들 녀석이 진짜 복잡하게 만들어버리게 만드는 녀석.
   */
  public void setAsRandom() {
    final int length = new Random().nextInt(100) - 1;

    if (0 <= length) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < length; i++) {
        sb.append(i % 10);
      }
      this.hidden = sb.toString();
    }
  }

  /**
   * 이놈을 공격합시다.
   */
  public boolean someMethod(String text) {
    if (null == text) {
      throw new NullPointerException("text");
    } else if (3 > text.length()) {
      throw new IllegalArgumentException("text length : " + text.length());
    }

    return this.hidden.length() < text.length();
  }
}
