package kr.lul.pages.how.to.use.orm.om.model;

/**
 * @author justburrow
 * @since 2019/10/20
 */
public class Category {
  private long id;
  private String name;

  public Category() {
  }

  public Category(String name) {
    setName(name);
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringBuilder(Category.class.getSimpleName())
        .append("{id=").append(this.id)
        .append(", name='").append(this.name).append('\'')
        .append('}')
        .toString();
  }
}