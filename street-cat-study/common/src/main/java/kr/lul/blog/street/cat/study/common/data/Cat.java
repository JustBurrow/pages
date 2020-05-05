package kr.lul.blog.street.cat.study.common.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Entity(name = "Cat")
@Table(name = "cats",
    uniqueConstraints = @UniqueConstraint(name = "uq_cats", columnNames = {"chip_id", "device_id"}))
public class Cat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "chip_id", nullable = false, updatable = false)
  private UUID chipId;
  @Column(name = "device_id", nullable = false, updatable = false)
  private UUID deviceId;
  @Column(name = "memo")
  private String memo;
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  public Cat() {
  }

  public Cat(UUID chipId, UUID deviceId) {
    this.chipId = chipId;
    this.deviceId = deviceId;
  }

  @PrePersist
  private void prePersist() {
    this.updatedAt = this.createdAt = LocalDateTime.now();
  }

  public long getId() {
    return this.id;
  }

  public UUID getChipId() {
    return this.chipId;
  }

  public UUID getDeviceId() {
    return this.deviceId;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public boolean isDeleted() {
    return null != this.deletedAt;
  }

  public LocalDateTime getDeletedAt() {
    return this.deletedAt;
  }

  public LocalDateTime delete() {
    this.deletedAt = LocalDateTime.now();
    return this.deletedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (0L >= this.id || o == null || getClass() != o.getClass()) return false;

    return this.id == ((Cat) o).id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return new StringBuilder(Cat.class.getSimpleName())
               .append("{id=").append(this.id)
               .append(", chipId=").append(this.chipId)
               .append(", deviceId=").append(this.deviceId)
               .append(", memo='").append(this.memo).append('\'')
               .append(", createdAt=").append(this.createdAt)
               .append(", updatedAt=").append(this.updatedAt)
               .append(", deletedAt=").append(this.deletedAt)
               .append('}').toString();
  }
}
