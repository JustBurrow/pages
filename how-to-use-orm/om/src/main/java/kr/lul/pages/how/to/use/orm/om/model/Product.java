package kr.lul.pages.how.to.use.orm.om.model;

import java.util.Objects;

/**
 * @author justburrow
 * @since 2019/10/20
 */
public class Product {
  private long id;
  private String name;

  public Product() {
  }

  public Product(String name) {
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return this.id == product.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return new StringBuilder(Product.class.getSimpleName())
        .append("{id=").append(this.id)
        .append(", name='").append(this.name).append('\'')
        .append('}')
        .toString();
  }
}
