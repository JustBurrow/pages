package kr.lul.pages.spring.boot14.v1;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "foo")
public class Foo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int     id;
  @Column(name = "create_utc", nullable = false, updatable = false)
  @Convert(converter = InstantBigintConverter.class)
  private Instant create;

  public Foo() {
  }

  @PrePersist
  private void prePersist() {
    this.create = Instant.now();
  }

  public int getId() {
    return this.id;
  }

  public Instant getCreate() {
    return this.create;
  }
}
