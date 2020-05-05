package kr.lul.blog.street.cat.study.api.controller.request;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public class AddRequest {
  @NotNull
  private UUID chipId;
  @NotNull
  private UUID deviceId;

  public AddRequest() {
  }

  public AddRequest(@NotNull UUID chipId, @NotNull UUID deviceId) {
    this.chipId = chipId;
    this.deviceId = deviceId;
  }

  public UUID getChipId() {
    return this.chipId;
  }

  public void setChipId(UUID chipId) {
    this.chipId = chipId;
  }

  public UUID getDeviceId() {
    return this.deviceId;
  }

  public void setDeviceId(UUID deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public String toString() {
    return format("(chipId=%s, deviceId=%s)", this.chipId, this.deviceId);
  }
}
