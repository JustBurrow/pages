package kr.lul.blog.street.cat.study.common.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Entity(name = "Use")
@Table(name = "uses",
    indexes = @Index(name = "idx_uses", columnList = "measured_at ASC, chip_id ASC, device_id ASC"))
public class Use {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private long id;
  @Column(name = "chip_id", nullable = false, updatable = false)
  private UUID chipId;
  @Column(name = "device_id", nullable = false, updatable = false)
  private UUID deviceId;
  @Column(name = "type", nullable = false, updatable = false)
  @Enumerated(EnumType.ORDINAL)
  private UseType type;
  @Column(name = "value", nullable = false, updatable = false)
  private int value;
  @Column(name = "measured_at", nullable = false, updatable = false)
  private LocalDateTime measuredAt;
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  public Use() {
  }

  public Use(UUID chipId, UUID deviceId, UseType type, int value, LocalDateTime measuredAt) {
    this.chipId = chipId;
    this.deviceId = deviceId;
    this.type = type;
    this.value = value;
    this.measuredAt = measuredAt;
  }

  @PrePersist
  private void prePersist() {
    this.createdAt = LocalDateTime.now();
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

  public UseType getType() {
    return this.type;
  }

  public int getValue() {
    return this.value;
  }

  public LocalDateTime getMeasuredAt() {
    return this.measuredAt;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return this.id == ((Use) o).id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return new StringBuilder(Use.class.getSimpleName())
               .append("{id=").append(this.id)
               .append(", chipId=").append(this.chipId)
               .append(", deviceId=").append(this.deviceId)
               .append(", type=").append(this.type)
               .append(", value=").append(this.value)
               .append(", measuredAt=").append(this.measuredAt)
               .append(", createdAt=").append(this.createdAt)
               .append('}').toString();
  }
}
