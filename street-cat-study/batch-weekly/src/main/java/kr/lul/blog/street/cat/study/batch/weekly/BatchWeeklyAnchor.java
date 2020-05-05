package kr.lul.blog.street.cat.study.batch.weekly;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public abstract class BatchWeeklyAnchor {
  public static final Package PACKAGE = BatchWeeklyAnchor.class.getPackage();
  public static final String PACKAGE_NAME = BatchWeeklyAnchor.class.getPackageName();

  protected BatchWeeklyAnchor() {
    throw new UnsupportedOperationException();
  }
}
