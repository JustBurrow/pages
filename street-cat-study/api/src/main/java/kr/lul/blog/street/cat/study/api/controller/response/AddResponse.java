package kr.lul.blog.street.cat.study.api.controller.response;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2020/05/05
 */
public class AddResponse {
  private UUID chipId;
  private LocalDateTime createdAt;

  public AddResponse(UUID chipId, LocalDateTime createdAt) {
    this.chipId = chipId;
    this.createdAt = createdAt;
  }

  public UUID getChipId() {
    return this.chipId;
  }

  public void setChipId(UUID chipId) {
    this.chipId = chipId;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return format("(chipId=%s, createdAt=%s)", this.chipId, this.createdAt);
  }
}
