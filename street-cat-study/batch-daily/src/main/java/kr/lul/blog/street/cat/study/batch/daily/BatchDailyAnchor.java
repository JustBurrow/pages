package kr.lul.blog.street.cat.study.batch.daily;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public abstract class BatchDailyAnchor {
  public static final Package PACKAGE = BatchDailyAnchor.class.getPackage();
  public static final String PACKAGE_NAME = BatchDailyAnchor.class.getPackageName();

  protected BatchDailyAnchor() {
    throw new UnsupportedOperationException();
  }
}
