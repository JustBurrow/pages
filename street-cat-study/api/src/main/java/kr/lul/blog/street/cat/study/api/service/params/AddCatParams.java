package kr.lul.blog.street.cat.study.api.service.params;

import java.util.UUID;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public class AddCatParams {
  private UUID chipId;
  private UUID deviceId;

  public AddCatParams(UUID chipId, UUID deviceId) {
    this.chipId = chipId;
    this.deviceId = deviceId;
  }

  public UUID getChipId() {
    return this.chipId;
  }

  public UUID getDeviceId() {
    return this.deviceId;
  }

  @Override
  public String toString() {
    return format("(chipId=%s, deviceId=%s)", this.chipId, this.deviceId);
  }
}
