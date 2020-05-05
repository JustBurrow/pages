package kr.lul.blog.street.cat.study.common.data;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2020/05/05
 */
@Entity(name = "Device")
@Table(name = "devices",
    uniqueConstraints = @UniqueConstraint(name = "uq_device_id", columnNames = "device_id"))
public class Device {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private long id;
  @Column(name = "device_id", nullable = false, unique = true, updatable = false)
  private UUID deviceId;
  @Column(name = "type", nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private DeviceType type;

  public Device() {
  }

  public Device(UUID deviceId, DeviceType type) {
    this.deviceId = deviceId;
    this.type = type;
  }

  public long getId() {
    return this.id;
  }

  public UUID getDeviceId() {
    return this.deviceId;
  }

  public DeviceType getType() {
    return this.type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return this.id == ((Device) o).id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return format("%s(id=%d, deviceId=%s, type=%s)", Device.class.getSimpleName(), this.id, this.deviceId, this.type);
  }
}
