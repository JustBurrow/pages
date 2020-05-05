package kr.lul.blog.street.cat.study.common;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public abstract class CommonAnchor {
  public static final Package PACKAGE = CommonAnchor.class.getPackage();
  public static final String PACKAGE_NAME = CommonAnchor.class.getPackageName();

  protected CommonAnchor() {
    throw new UnsupportedOperationException();
  }
}
