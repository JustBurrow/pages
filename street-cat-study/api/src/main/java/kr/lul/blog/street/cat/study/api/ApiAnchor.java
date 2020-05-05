package kr.lul.blog.street.cat.study.api;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public abstract class ApiAnchor {
  public static final Package PACKAGE = ApiAnchor.class.getPackage();
  public static final String PACKAGE_NAME = ApiAnchor.class.getPackageName();

  protected ApiAnchor() {
    throw new UnsupportedOperationException();
  }
}
