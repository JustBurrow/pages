package kr.lul.pages.how.to.use.orm.orm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Entity(name = "Category")
@Table(name = "category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private long id;
  @Column(name = "name", nullable = false)
  private String name;
  @ManyToMany
  @JoinTable(name = "rel_category_product",
      joinColumns = @JoinColumn(name = "category",
          nullable = false,
          updatable = false,
          foreignKey = @ForeignKey(name = "FK_CATEGORY_PRODUCT_PK_CATEGORY"),
          referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "product",
          nullable = false,
          updatable = false,
          foreignKey = @ForeignKey(name = "FK_CATEGORY_PRODUCT_PK_PRODUCT"),
          referencedColumnName = "id"))
  private List<Product> products = new ArrayList<>();

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

  public List<Product> getProducts() {
    return unmodifiableList(this.products);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Category)) return false;
    Category category = (Category) o;
    return this.id == category.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
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
