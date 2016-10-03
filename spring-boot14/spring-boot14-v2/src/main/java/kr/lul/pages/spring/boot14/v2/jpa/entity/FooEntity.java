package kr.lul.pages.spring.boot14.v2.jpa.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import kr.lul.pages.spring.boot14.v2.domain.Foo;
import kr.lul.pages.spring.boot14.v2.jpa.converter.InstantBigintConverter;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@Entity
@Table(name = "foo")
public class FooEntity implements Foo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int     id;
  @Column(name = "create_utc", nullable = false, updatable = false)
  @Convert(converter = InstantBigintConverter.class)
  private Instant create;

  public FooEntity() {
  }

  @PrePersist
  private void prePersist() {
    this.create = Instant.now();
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public int getId() {
    return this.id;
  }

  /*
   * (non-Javadoc)
   * @author Just Burrow
   * @since 2016. 10. 3.
   */
  @Override
  public Instant getCreate() {
    return this.create;
  }
}
